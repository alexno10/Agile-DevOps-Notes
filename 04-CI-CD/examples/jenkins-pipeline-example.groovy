pipeline {
    // Run on any available agent
    agent any

    // Define environment variables globally for the pipeline
    environment {
        DOCKER_REGISTRY = 'registry.example.com'
        IMAGE_NAME = 'my-organization/my-app'
        // Access Jenkins credentials securely
        DOCKER_CREDS = credentials('docker-registry-credentials')
        KUBECONFIG = credentials('kubernetes-config-prod')
    }

    options {
        // Keep only the last 10 builds to save disk space
        buildDiscarder(logRotator(numToKeepStr: '10'))
        // Add timestamps to console output
        timestamps()
        // Timeout the entire pipeline after 1 hour
        timeout(time: 1, unit: 'HOURS')
    }

    stages {
        // ---------------------------------------------------------
        // 1. DEPENDENCIES & LINTING
        // ---------------------------------------------------------
        stage('Install & Lint') {
            steps {
                echo "Installing dependencies..."
                sh 'npm ci'
                
                echo "Running Linter..."
                sh 'npm run lint'
            }
        }

        // ---------------------------------------------------------
        // 2. PARALLEL TESTING
        // ---------------------------------------------------------
        stage('Testing') {
            parallel {
                stage('Unit Tests') {
                    steps {
                        echo "Running Unit Tests..."
                        sh 'npm run test:unit'
                    }
                }
                stage('Security Scan') {
                    steps {
                        echo "Running Static Application Security Testing (SAST)..."
                        // Example mock command
                        sh 'npm audit --audit-level=high'
                    }
                }
            }
        }

        // ---------------------------------------------------------
        // 3. BUILD
        // ---------------------------------------------------------
        stage('Build Artifact') {
            steps {
                echo "Building application bundle..."
                sh 'npm run build'
            }
        }

        // ---------------------------------------------------------
        // 4. DOCKER BUILD & PUSH
        // ---------------------------------------------------------
        stage('Docker Build & Push') {
            // Only run on main branch
            when {
                branch 'main'
            }
            steps {
                echo "Building Docker image..."
                sh "docker build -t ${DOCKER_REGISTRY}/${IMAGE_NAME}:${GIT_COMMIT} ."
                
                echo "Pushing Docker image to registry..."
                sh "echo $DOCKER_CREDS_PSW | docker login -u $DOCKER_CREDS_USR --password-stdin ${DOCKER_REGISTRY}"
                sh "docker push ${DOCKER_REGISTRY}/${IMAGE_NAME}:${GIT_COMMIT}"
            }
        }

        // ---------------------------------------------------------
        // 5. DEPLOY TO STAGING
        // ---------------------------------------------------------
        stage('Deploy to Staging') {
            when {
                branch 'main'
            }
            steps {
                echo "Deploying to Staging Environment..."
                // Example kubectl deployment
                sh """
                kubectl config use-context staging
                kubectl set image deployment/myapp myapp=${DOCKER_REGISTRY}/${IMAGE_NAME}:${GIT_COMMIT} -n staging
                """
            }
        }

        // ---------------------------------------------------------
        // 6. INTEGRATION TESTS
        // ---------------------------------------------------------
        stage('Integration Tests') {
            when {
                branch 'main'
            }
            steps {
                echo "Running automated integration tests against Staging..."
                // Example integration test script
                sh 'npm run test:integration -- --target=https://staging.example.com'
            }
        }

        // ---------------------------------------------------------
        // 7. DEPLOY TO PRODUCTION
        // ---------------------------------------------------------
        stage('Deploy to Production') {
            when {
                branch 'main'
            }
            // Require manual approval before proceeding to production
            input {
                message "Approve deployment to Production?"
                ok "Deploy"
                submitter "release-managers"
            }
            steps {
                echo "Deploying to Production Environment..."
                withCredentials([file(credentialsId: 'kubernetes-config-prod', variable: 'KUBECONFIG')]) {
                    sh """
                    export KUBECONFIG=\$KUBECONFIG
                    kubectl set image deployment/myapp myapp=${DOCKER_REGISTRY}/${IMAGE_NAME}:${GIT_COMMIT} -n prod
                    kubectl rollout status deployment/myapp -n prod
                    """
                }
            }
        }
    }

    // ---------------------------------------------------------
    // POST PIPELINE ACTIONS
    // ---------------------------------------------------------
    post {
        always {
            echo "Pipeline execution completed."
            // Archive test results
            junit allowEmptyResults: true, testResults: '**/test-results/*.xml'
        }
        success {
            echo "Pipeline succeeded! ✅"
            // Example notification
            // slackSend channel: '#deployments', color: 'good', message: "SUCCESS: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' deployed to Prod."
        }
        failure {
            echo "Pipeline failed. ❌"
            // slackSend channel: '#alerts', color: 'danger', message: "FAILED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'."
        }
    }
}
