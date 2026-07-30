# 🏢 Case Study: Migrating from Legacy to DevOps

## 🌑 The Initial State: "The Wall of Confusion"

Acme Corp, a mid-sized financial services company, was stuck in the past. 
*   **Architecture:** A massive Java monolith.
*   **Process:** strict Waterfall. Planning took months, development took months, and testing was a manual nightmare.
*   **Deployments:** Releases happened exactly four times a year on weekends. The "Release Document" was a 40-page Word file. Operations engineers manually copied WAR files to WebSphere servers via FTP. 
*   **Culture:** Developers threw code over the proverbial "Wall of Confusion" to Operations. When the inevitable deployment failure occurred, Dev blamed Ops ("It worked on my machine!"), and Ops blamed Dev ("Your code is garbage!").

## ⚡ The Trigger for Change

A nimble startup entered their market, pushing updates daily. Acme Corp lost a major client because a critical compliance feature took six months to release. The CTO mandated a shift to DevOps to survive.

---

## 🛤️ The Journey

### Phase 1: Assessment and The Pilot Team
Instead of a massive "big bang" reorganization, Acme selected a small, low-risk project (an internal reporting tool) to act as a **Pilot Team**. This team was cross-functional, containing a Product Owner, Devs, QA, and one embedded Ops engineer. They were given autonomy to choose their tools.

### Phase 2: Tooling Adoption (Breaking the Ice)
The pilot team tackled the lowest-hanging fruit: Version Control and CI.
1.  Migrated from SVN to Git.
2.  Implemented Jenkins (later GitHub Actions) to automatically compile code and run unit tests on every commit.

> [!TIP]
> Tooling doesn't create DevOps, but it enforces the necessary discipline. Continuous Integration proved to the developers that their changes weren't breaking the build.

### Phase 3: Infrastructure as Code (IaC)
The embedded Ops engineer introduced Terraform. Instead of manually configuring WebSphere on bare metal, they began provisioning lightweight Docker containers on AWS. Environments (Dev, QA, Staging) finally became identical, eliminating the "worked on my machine" excuse.

### Phase 4: Culture Change (The Hard Part)
As the pilot team succeeded, the practices scaled to the legacy monolith. This met fierce resistance. Ops feared losing their jobs to automation. Devs resisted writing automated tests. 
The turning point was the introduction of **Blameless Postmortems**. When a junior dev accidentally dropped a staging database, instead of being fired, the team held an RCA (Root Cause Analysis) and wrote a script to automate DB backups and restrict drop permissions. Trust began to build.

### Phase 5: Scaling and Microservices
The monolith was slowly strangled. New features were built as independent microservices. The organization adopted a "Team Topologies" model, with a dedicated Platform Team building a self-service internal developer portal.

---

## 📈 The Results (DORA Metrics)

After two years, Acme Corp measured their progress using the industry-standard DORA metrics:

| Metric | Before (Legacy) | After (DevOps) |
| :--- | :--- | :--- |
| **Deployment Frequency** | 4 times per year | Multiple times per day |
| **Lead Time for Changes** | 6 months | 4 hours |
| **Time to Restore Service (MTTR)** | 1-2 days | 15 minutes |
| **Change Failure Rate** | ~40% (rollback common) | < 5% |

## 🧠 Lessons Learned

1.  **Don't boil the ocean:** Start with a pilot team to prove the concept and generate internal champions.
2.  **Culture eats tools for breakfast:** Buying Kubernetes won't fix a toxic blame culture. Focus on psychological safety first.
3.  **Automate tests before deployments:** If you automate deployments without automated testing, you just deploy bugs faster.
