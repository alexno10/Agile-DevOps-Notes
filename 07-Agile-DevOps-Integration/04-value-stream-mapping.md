# 🗺️ Value Stream Mapping

Originating from Lean Manufacturing (specifically the Toyota Production System), Value Stream Mapping (VSM) is a powerful exercise to visualize the entire lifecycle of a product from customer request to delivery. In DevOps, it is used to identify bottlenecks in the software delivery pipeline.

## 🎯 Why VSM Matters in DevOps

You cannot optimize a process you cannot see. VSM helps Agile and DevOps teams shift their focus from *local optimization* (e.g., making the CI build 10 seconds faster) to *global optimization* (e.g., removing a 3-day manual security review).

> [!IMPORTANT]
> The goal of VSM is to identify and eliminate **waste**—anything that does not add value to the customer.

## 🗑️ Identifying Waste in Software

1.  **Waiting:** Code waiting for code review, waiting for a QA environment to spin up.
2.  **Overproduction:** Building features users don't actually need (often caused by large batches).
3.  **Defects:** Bugs that require rework, failed deployments.
4.  **Transport/Motion:** Handoffs between siloed teams (Dev handing off to Ops).
5.  **Extra Processing:** Unnecessary approvals, duplicate data entry in Jira and ServiceNow.

---

## ⏱️ Key Time Metrics

When creating a map, we track three distinct time metrics:

*   **Lead Time (LT):** The total time elapsed from the moment a request is made until it is delivered to the customer.
*   **Process Time (PT):** (Also called Touch Time). The actual time spent actively working on the task, creating value.
*   **Wait Time:** Time spent idling in a queue or waiting for an approval. (Wait Time = Lead Time - Process Time).

*Efficiency Ratio = (Process Time / Lead Time) * 100*

---

## 📊 Example: Software Delivery Value Stream Map

A typical map compares the **Current State** (with all its flaws) to an idealized **Future State**.

```mermaid
graph LR
    subgraph The Process Steps
        A[Backlog Refinement] -->|Hand-off| B[Development]
        B -->|Wait for Review| C[Code Review]
        C -->|Queue| D[QA Testing]
        D -->|CAB Approval| E[Deployment]
    end

    subgraph Time Metrics (Current State)
        A_T[PT: 2 hrs<br/>Wait: 5 days]
        B_T[PT: 3 days<br/>Wait: 1 day]
        C_T[PT: 1 hr<br/>Wait: 2 days]
        D_T[PT: 4 hrs<br/>Wait: 4 days]
        E_T[PT: 2 hrs<br/>Wait: 7 days]
    end

    A -.-> A_T
    B -.-> B_T
    C -.-> C_T
    D -.-> D_T
    E -.-> E_T

    style A_T fill:#ffcccc,stroke:#ff0000
    style C_T fill:#ffcccc,stroke:#ff0000
    style D_T fill:#ffcccc,stroke:#ff0000
    style E_T fill:#ffcccc,stroke:#ff0000
```

### Analysis of the Example
*   **Total Process Time:** ~3.5 days of actual work.
*   **Total Lead Time:** ~19 days total.
*   **Efficiency:** Under 20%. The vast majority of the time, the code is simply *waiting*.

### The DevOps Fix (Future State)
To improve this value stream, the team might implement:
1.  **Automated Testing** to replace the manual QA queue.
2.  **Continuous Delivery** to eliminate the manual deployment wait and CAB approval.
3.  **Pair Programming** to eliminate the asynchronous Code Review wait time.
