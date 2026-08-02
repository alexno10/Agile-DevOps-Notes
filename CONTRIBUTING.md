# 🤝 Contributing to Agile-DevOps-Notes

First off — thank you for taking the time to contribute! Every fix, addition, and improvement makes this resource better for everyone learning Agile and DevOps.

---

## 💡 What You Can Contribute

- **Fix typos or factual errors** — small PRs are just as welcome as big ones
- **Improve explanations** — clearer wording, better examples, more context
- **Add Mermaid diagrams** — visual learners will thank you
- **Add new sections or topics** — propose via an Issue first for larger additions
- **Add real-world examples** — code snippets, pipeline configs, case studies

---

## 🚀 How to Contribute

```bash
# 1. Fork the repository on GitHub
# 2. Clone your fork
git clone https://github.com/<your-username>/Agile-DevOps-Notes.git

# 3. Create a descriptive branch
git checkout -b fix/scrum-ceremonies-typo
# or
git checkout -b feat/add-kubernetes-section

# 4. Make your changes (see Style Guide below)

# 5. Commit with a clear message
git commit -m "fix: correct Sprint Planning timebox for 2-week sprints"

# 6. Push to your fork
git push origin fix/scrum-ceremonies-typo

# 7. Open a Pull Request on GitHub
```

---

## ✍️ Style Guide

Follow these conventions to keep the repository consistent.

### Headings & Structure
- Use a single `#` H1 at the top of each file (the page title)
- Use `##` and `###` for sections and sub-sections
- Start the H1 with a relevant emoji (e.g., `# 🔄 CI/CD Overview`)

### GitHub Alerts
Use GitHub-native alerts to highlight key information:
```markdown
> [!NOTE]
> Background context or helpful clarification.

> [!TIP]
> Best practices or performance suggestions.

> [!IMPORTANT]
> Critical information the reader must not miss.

> [!WARNING]
> Potential pitfalls, anti-patterns, or things to avoid.

> [!CAUTION]
> High-risk actions that could cause problems.
```

> [!WARNING]
> Never put content on the same line as the alert tag. Always put it on the **next line** starting with `>`.

### Mermaid Diagrams
- Always use [GitHub-supported Mermaid diagram types](https://docs.github.com/en/get-started/writing-on-github/working-with-advanced-formatting/creating-diagrams): `graph`, `flowchart`, `sequenceDiagram`, `pie`, `gitGraph`, `erDiagram`
- **Avoid** unsupported types: `timeline`, `mindmap`, `journey`, `kanban`
- Quote subgraph names that contain special characters: `subgraph LABEL ["Name (with parens)"]`

### Tables
- Use tables for comparisons, glossaries, and structured data
- Always include a header row separator (`|---|---|`)
- Left-align text columns, right-align number columns

### File & Folder Naming
- Use **kebab-case** for all filenames: `ci-cd-overview.md` ✅, `CiCdOverview.md` ❌
- Prefix files with a number when order matters: `01-scrum-overview.md`
- Keep folder names lowercase with hyphens: `01-agile-fundamentals/`

---

## ✅ PR Checklist

Before submitting your Pull Request, please confirm:

- [ ] Content is accurate and factually correct
- [ ] Spelling and grammar are checked
- [ ] Mermaid diagrams render correctly (test at [mermaid.live](https://mermaid.live))
- [ ] GitHub alert syntax is correct (content on new line)
- [ ] File follows the naming convention (kebab-case, numbered if ordered)
- [ ] README Table of Contents is updated if a new file was added
- [ ] No broken internal links

---

*Thank you for helping make this resource better! 🙌*
