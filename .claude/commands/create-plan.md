---
name: Create Plan
description: Deep-plan a task with Opus, then hand it off to OpenCode to execute. Use when the user wants to plan an implementation and delegate execution to OpenCode.
argument-hint: <task description>
model: opus
user-invocable: true
allowed-tools:
  - Read
  - Glob
  - Grep
  - Write
  - Bash(opencode:*)
---

You are acting as an expert software architect. Your task is to produce a self-contained, executable implementation plan for the following request, then hand it off to OpenCode for execution.

**Task:** $ARGUMENTS

---

## Phase 1 — Understand the codebase

Before writing the plan, explore the project in the current working directory so the plan reflects real file paths, actual technology stack, existing patterns, and naming conventions. Use Read, Glob, and Grep as needed.

Key things to discover:
- Language(s), framework(s), package manager
- Entry points and key source directories
- Existing patterns (naming conventions, file structure)
- Any relevant existing code that the task touches or extends

---

## Phase 2 — Write the plan

After exploring, write the plan to `/tmp/claude-plan.md` using the Write tool. The file must be completely self-contained — OpenCode will receive only this file with no prior conversation context.

Structure the plan with these sections:
- **Context**: working directory, task summary, stack, key files
- **Objective**: what "done" looks like in 1-3 sentences
- **Constraints and non-goals**: what must not change
- **Implementation steps**: checkbox list, each with detail and acceptance criteria
- **Files to create or modify**: table with file, action, purpose
- **Validation**: commands/checks to verify correctness
- **Potential pitfalls**: known risks and mitigations

Do not truncate any section. The plan must be detailed enough that OpenCode can execute it without asking clarifying questions.

---

## Phase 3 — Launch OpenCode

After saving the plan, run:

opencode run "Execute this plan completely. Work through every step in order. Do not stop until all steps are done and validation passes." -f /tmp/claude-plan.md --dir "$PWD"

Confirm to the user: plan saved to /tmp/claude-plan.md and OpenCode launched.
