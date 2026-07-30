# 📦 Scrum Artifacts

> [!NOTE]  
> Scrum’s artifacts represent work or value. They are designed to maximize transparency of key information. Thus, everyone inspecting them has the same basis for adaptation.

Each artifact contains a commitment to ensure it provides information that enhances transparency and focus against which progress can be measured:
- For the **Product Backlog** it is the **Product Goal**.
- For the **Sprint Backlog** it is the **Sprint Goal**.
- For the **Increment** it is the **Definition of Done**.

---

## 🗃️ 1. Product Backlog

The Product Backlog is an emergent, ordered list of what is needed to improve the product. It is the single source of work undertaken by the Scrum Team.

- **Commitment: Product Goal:** The Product Goal describes a future state of the product which can serve as a target for the Scrum Team to plan against. The Product Goal is in the Product Backlog.

### Backlog Refinement
Product Backlog refinement is the act of breaking down and further defining Product Backlog items into smaller more precise items. This is an ongoing activity to add details, such as a description, order, and size.

### User Stories & Story Points
Work items are often expressed as User Stories.
- **Format:** `As a <type of user>, I want <some goal> so that <some reason>.`
- **Example:** `As a registered user, I want to reset my password via email so that I can regain access to my account if I forget it.`

**Story Points** are a relative unit of measure used to estimate the effort required to implement a backlog item. They consider complexity, amount of work, and risk/uncertainty, often using a Fibonacci sequence (1, 2, 3, 5, 8, 13...).

### INVEST Criteria for Good Stories
| Letter | Meaning | Description |
| :---: | :--- | :--- |
| **I** | Independent | Stories should be self-contained and not rely on others. |
| **N** | Negotiable | Stories are not contracts; space is left for discussion. |
| **V** | Valuable | Must deliver value to the stakeholders/users. |
| **E** | Estimable | The team must have enough info to size it. |
| **S** | Small | Small enough to be completed within a single Sprint. |
| **T** | Testable | Must have clear acceptance criteria to know when it's done. |

---

## 🏃 2. Sprint Backlog

The Sprint Backlog is composed of the Sprint Goal (why), the set of Product Backlog items selected for the Sprint (what), as well as an actionable plan for delivering the Increment (how).

- **Commitment: Sprint Goal:** The Sprint Goal is the single objective for the Sprint. Although the Sprint Goal is a commitment by the Developers, it provides flexibility in terms of the exact work needed to achieve it.

### Task Breakdown
During Sprint Planning or throughout the Sprint, Developers often break down the selected User Stories into smaller, technical tasks (e.g., "Update database schema", "Create API endpoint", "Write unit tests").

> [!TIP]
> The Sprint Backlog is a highly visible, real-time picture of the work that the Developers plan to accomplish during the Sprint. It belongs solely to the Developers.

---

## 🎁 3. Increment

An Increment is a concrete stepping stone toward the Product Goal. Each Increment is additive to all prior Increments and thoroughly verified, ensuring that all Increments work together.

- **Commitment: Definition of Done (DoD):** The Definition of Done is a formal description of the state of the Increment when it meets the quality measures required for the product.

### Working Software
The moment a Product Backlog item meets the Definition of Done, an Increment is born. If a Product Backlog item does not meet the Definition of Done, it cannot be released or even presented at the Sprint Review.

### Example: Definition of Done vs Acceptance Criteria

> [!IMPORTANT]
> Acceptance Criteria are specific to a single User Story. The Definition of Done applies to *all* items in the Increment.

| Aspect | Acceptance Criteria (Specific) | Definition of Done (Universal) |
| :--- | :--- | :--- |
| **Scope** | Applies to one specific User Story. | Applies globally to every task/story in the Sprint. |
| **Focus** | Functional requirements and business logic. | Quality, compliance, and technical standards. |
| **Example** | "Password reset email contains a unique token link." | "Code is reviewed by 2 peers." |
| **Example** | "Token expires after 15 minutes." | "All unit tests pass with >80% coverage." |
| **Example** | "Invalid token shows an appropriate error message." | "Code is deployed to the staging environment." |
| **Example** | "User is logged in upon successful reset." | "Feature flag is implemented and documented." |
