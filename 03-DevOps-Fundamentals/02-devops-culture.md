# 🤝 DevOps Culture & Principles

> [!TIP]
> DevOps is a cultural transformation. If you adopt the tools without the culture, you simply fail faster.

## 🌟 The CALMS Model

Coined by Jez Humble (co-author of *The DevOps Handbook*), the CALMS framework is the definitive model for assessing an organization's readiness for DevOps.

### 1. 🧠 Culture
Culture is the bedrock of DevOps. Without it, the rest of the model collapses.
* **Psychological Safety:** Teams must feel safe to take risks, experiment, and admit mistakes without fear of punishment.
* **Blameless Postmortems:** When incidents occur, the focus is *never* on "who made the mistake," but rather on "what systemic failure allowed this mistake to happen?" This fosters a culture of learning rather than hiding errors.
* **Shared Goals:** Breaking down the "us vs. them" mentality.

### 2. 🤖 Automation
> [!IMPORTANT]
> If a task requires human intervention more than once, it should be automated.

* **Why Automate?** To eliminate manual errors, increase speed, provide consistent environments, and free up human intellect for creative problem-solving rather than repetitive toil.
* **What to Automate?** Infrastructure provisioning (Infrastructure as Code), testing, deployments (CI/CD), security scanning, and monitoring.

### 3. 📉 Lean
Applying Lean manufacturing principles to software delivery.
* **Value Stream Mapping (VSM):** Visualizing the entire process from ideation to production to identify bottlenecks and wait times.
* **Eliminating Waste:** Removing manual approvals, handoffs, unnecessary documentation, and partially done work.
* **Small Batch Sizes:** Releasing small, incremental changes rather than massive updates reduces risk and makes rollbacks easier.

### 4. 📏 Measurement
"You cannot improve what you cannot measure." Data drives DevOps.

#### The DORA Metrics
The DevOps Research and Assessment (DORA) team established four key metrics that indicate software delivery performance.

| Metric | Definition | Good/High Performer | Elite Performer |
| :--- | :--- | :--- | :--- |
| **Deployment Frequency (DF)** | How often code is successfully deployed to production. | Between once per day and once per week. | On-demand (multiple times a day). |
| **Lead Time for Changes (LT)** | The time it takes from code commit to code running in production. | Between one day and one week. | Less than one hour. |
| **Time to Restore Service (MTTR)** | How long it takes to recover from a failure in production. | Less than one day. | Less than one hour. |
| **Change Failure Rate (CFR)** | The percentage of deployments that result in degraded service requiring remediation. | 16% - 30% | 0% - 15% |

### 5. 🤝 Sharing
Fostering an environment of collaboration and transparency.
* **Knowledge Sharing:** Breaking down knowledge silos through pairing, lunch-and-learns, and comprehensive documentation.
* **Inner Source:** Applying open-source practices internally. Anyone in the company can contribute to any repository.

---

## 🛣️ The Three Ways

Gene Kim, another co-author of *The DevOps Handbook*, conceptualized the underlying principles of DevOps as "The Three Ways."

### The First Way: Flow (Left to Right)
Focuses on understanding and increasing the speed of the flow of work from Development to Operations to the Customer.
* Make work visible.
* Limit Work in Progress (WIP).
* Reduce batch sizes.
* Build quality in (automated testing).

### The Second Way: Feedback (Right to Left)
Focuses on creating fast and continuous feedback loops from Operations and Customers back to Development.
* See problems as they occur (monitoring/observability).
* Swarm and solve problems to build new knowledge.
* Push quality closer to the source.

### The Third Way: Continuous Learning and Experimentation
Focuses on creating a culture that fosters two things: continual experimentation (taking risks and learning from failure) and understanding that repetition and practice are the prerequisites to mastery.
* Institutionalize the improvement of daily work.
* Transform local discoveries into global improvements.
* Inject failures into the system to increase resilience (Chaos Engineering).
