# 🛠️ DevOps Toolchain Reference

> Tools organized by the DevOps lifecycle phase. Use this as a starting point — the right tool depends on your stack, team size, and cloud provider.

---

## 📐 Plan

*Define work, track progress, manage requirements.*

| Tool | Type | Best For |
|------|------|----------|
| **Jira** | Issue tracker | Large teams; deep Scrum/Kanban support; integrates with almost everything |
| **Linear** | Issue tracker | Fast, modern UI; beloved by engineering teams; great for startups |
| **Azure DevOps Boards** | Issue tracker | Microsoft/Azure shops; tight integration with Azure Pipelines |
| **Trello** | Kanban board | Simple projects; visual teams; great for non-engineers |
| **Confluence** | Wiki/Docs | Team knowledge base; pairs naturally with Jira |
| **Notion** | Wiki/Docs | All-in-one workspace; flexible for docs, tasks, and databases |

---

## 💻 Code

*Write, review, and version-control source code.*

| Tool | Type | Best For |
|------|------|----------|
| **Git** | VCS | Industry standard; distributed version control |
| **GitHub** | Git hosting | Open source; GitHub Actions CI/CD; large ecosystem |
| **GitLab** | Git hosting | Self-hosted option; built-in CI/CD, registry, and security scanning |
| **Bitbucket** | Git hosting | Atlassian ecosystem (Jira integration); good for enterprise |
| **VS Code** | Editor | Most popular editor; massive extension ecosystem |
| **pre-commit** | Git hooks | Run linters/formatters before each commit; enforces code quality locally |

> [!TIP]
> Adopt **trunk-based development** (short-lived branches, frequent merges to `main`) to maximize the benefits of CI.

---

## 🔨 Build

*Compile source code into deployable artifacts.*

| Tool | Type | Best For |
|------|------|----------|
| **Docker Build** | Container image builder | Packaging apps + dependencies into portable images |
| **Maven** | Build tool | Java/JVM projects; dependency management |
| **Gradle** | Build tool | Java/Kotlin/Android; faster than Maven with caching |
| **npm / pnpm** | Package manager | Node.js projects; pnpm is faster with less disk usage |
| **Make** | Build automation | Universal; great for multi-language or scripting build steps |
| **Buildkit** | Docker backend | Parallel, cached Docker builds; used by default in modern Docker |

---

## 🧪 Test

*Validate correctness, performance, and security.*

| Tool | Category | Best For |
|------|----------|----------|
| **Jest** | Unit testing | JavaScript/TypeScript projects |
| **pytest** | Unit testing | Python projects; simple and powerful |
| **JUnit** | Unit testing | Java projects |
| **Selenium** | E2E testing | Browser automation; cross-browser UI testing |
| **Playwright** | E2E testing | Modern alternative to Selenium; faster, more reliable |
| **k6** | Load/Perf testing | Developer-friendly performance testing with JS scripts |
| **SonarQube** | Static analysis | Code quality and security hotspot detection |
| **Trivy** | Security scanning | Container image and filesystem vulnerability scanning |
| **OWASP ZAP** | DAST | Dynamic security testing of running web applications |

> [!IMPORTANT]
> Follow the **Test Pyramid**: many unit tests → fewer integration tests → even fewer E2E tests. This keeps the suite fast and reliable.

---

## 🚀 Release (CI/CD)

*Automate the pipeline from commit to deployable artifact.*

| Tool | Hosting | Best For |
|------|---------|----------|
| **GitHub Actions** | Cloud (SaaS) | GitHub repos; huge marketplace; zero infrastructure |
| **GitLab CI** | Cloud + Self-hosted | GitLab repos; built-in; powerful `include` and `extends` |
| **Jenkins** | Self-hosted | Maximum flexibility; large plugin ecosystem; complex pipelines |
| **CircleCI** | Cloud (SaaS) | Fast builds; great Docker support; simple YAML config |
| **ArgoCD** | Self-hosted (K8s) | GitOps-based continuous delivery for Kubernetes |
| **Flux** | Self-hosted (K8s) | GitOps alternative to ArgoCD; lighter weight |
| **Tekton** | Self-hosted (K8s) | Cloud-native CI/CD pipelines on Kubernetes |

---

## ☁️ Deploy & Infrastructure

*Provision environments and deploy applications.*

| Tool | Category | Best For |
|------|----------|----------|
| **Terraform** | IaC (Declarative) | Multi-cloud infrastructure provisioning; industry standard |
| **Pulumi** | IaC (Imperative) | Infrastructure with real programming languages (Python, TS, Go) |
| **Ansible** | Config Management | Agentless; great for server configuration and app deployment |
| **Helm** | K8s Package Manager | Templating and versioning Kubernetes manifests |
| **Kubernetes** | Container Orchestration | Scaling, self-healing, and managing containerized applications |
| **AWS CDK** | IaC (Imperative) | AWS-native infrastructure using familiar languages |

---

## ⚙️ Operate

*Run and manage applications in production.*

| Tool | Category | Best For |
|------|----------|----------|
| **Kubernetes (K8s)** | Container Orchestration | Production-grade container management at scale |
| **Docker Compose** | Local Orchestration | Local development multi-container environments |
| **AWS ECS / Fargate** | Managed Containers | Simpler container hosting without managing K8s |
| **HashiCorp Nomad** | Workload Orchestrator | Simpler alternative to Kubernetes; supports non-container workloads |

---

## 📊 Monitor & Observe

*Detect issues before users do.*

| Tool | Category | Best For |
|------|----------|----------|
| **Prometheus** | Metrics collection | Pull-based metrics; pairs perfectly with Grafana |
| **Grafana** | Visualization | Dashboards for metrics, logs, and traces from any source |
| **Loki** | Log aggregation | Lightweight, label-based log aggregation (by Grafana Labs) |
| **Jaeger** | Distributed tracing | Open-source tracing; great for microservices debugging |
| **OpenTelemetry** | Observability standard | Vendor-neutral instrumentation for metrics, logs, and traces |
| **ELK Stack** | Log aggregation | Elasticsearch + Logstash + Kibana; powerful but resource-heavy |
| **Datadog** | Full-stack observability | All-in-one SaaS; expensive but very comprehensive |
| **PagerDuty** | Incident management | On-call scheduling, alerting, and incident response |
| **Sentry** | Error tracking | Real-time error monitoring for applications |

---

## 🔐 Security (DevSecOps)

*Shift security left into the pipeline.*

| Tool | Category | Best For |
|------|----------|----------|
| **Trivy** | SAST / SCA | Scan container images, filesystems, and IaC for vulnerabilities |
| **Snyk** | SCA / SAST | Developer-friendly; integrates into IDEs and CI pipelines |
| **OWASP ZAP** | DAST | Automated web app security scanning against running services |
| **HashiCorp Vault** | Secrets Management | Centralized secrets storage and dynamic credential generation |
| **Falco** | Runtime Security | Detects anomalous behavior in running containers (K8s) |
| **Checkov** | IaC Security | Static analysis of Terraform, CloudFormation, Helm charts |

---

## ⚡ Quick Selection Guide

| Situation | Recommended Stack |
|-----------|------------------|
| Small team, starting out | GitHub + GitHub Actions + Docker + Terraform |
| Microsoft / Azure shop | Azure DevOps + Helm + AKS + Azure Monitor |
| GitLab all-in-one | GitLab CI + GitLab Registry + Terraform + Prometheus |
| Kubernetes-native GitOps | GitHub Actions (CI) + ArgoCD (CD) + Helm + Prometheus + Grafana |
| Maximum self-hosted control | Jenkins + Harbor + Terraform + ELK Stack + Vault |

---

*📌 All tools listed are open-source or have a free tier unless otherwise noted.*
