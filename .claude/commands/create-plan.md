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
  - AskUserQuestion
---

You are acting as an expert software architect. Your task is to gather all necessary information upfront, produce a self-contained executable implementation plan, then hand it off to OpenCode for fully autonomous execution — no further questions or permission prompts after Phase 0.

**Task:** $ARGUMENTS

---

## Phase 0 — Gather all requirements upfront

Before exploring the codebase or writing the plan, do a quick scan (Glob/Grep only, no deep reads) to understand what's already there. Then identify every ambiguity or decision that would block implementation. Ask ALL of them in a single AskUserQuestion call — no follow-up questions allowed after this.

Guidelines for good questions:
- Only ask what you cannot infer from the code or the task description
- Aim for 2-4 questions maximum; fewer is better
- Make questions concrete with clear options the user can select

After receiving answers, proceed fully autonomously through Phases 1-3. Do NOT ask for confirmations, permissions, or clarifications at any point.

---

## Phase 1 — Understand the codebase

Explore the project thoroughly so the plan reflects real file paths, actual technology stack, existing patterns, and naming conventions. Use Read, Glob, and Grep as needed.

Key things to discover:
- Language(s), framework(s), package manager
- Entry points and key source directories
- Existing patterns (naming conventions, file structure)
- Any relevant existing code that the task touches or extends

---

## Phase 2 — Write the plan

After exploring, write the plan to `/tmp/claude-plan.md` using the Write tool. The file must be completely self-contained — OpenCode will receive only this file with no prior conversation context.

Structure the plan with these sections:
- **Context**: working directory, task summary, stack, key files, answers from Phase 0
- **Objective**: what "done" looks like in 1-3 sentences
- **Constraints and non-goals**: what must not change
- **Implementation steps**: checkbox list, each with detail and acceptance criteria
- **Files to create or modify**: table with file, action, purpose
- **Validation**: commands/checks to verify correctness
- **Potential pitfalls**: known risks and mitigations
- **Autonomy instructions**: OpenCode must not ask for permissions or clarifications — make every decision itself based on the plan

Do not truncate any section. The plan must be detailed enough that OpenCode can execute it without asking any clarifying questions.

---

## Phase 3 — Launch OpenCode

After saving the plan, run:

opencode run "Execute this plan completely and autonomously. Work through every step in order. Make all decisions yourself based on the plan — do not stop to ask for permissions or clarifications. Do not stop until all steps are done and validation passes." -f /tmp/claude-plan.md --dir "$PWD"

Confirm to the user: plan saved to /tmp/claude-plan.md and OpenCode launched. Implementation is running — no further interruptions will occur.
