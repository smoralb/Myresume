---
name: Publish to GitHub Pages and Push
description: Builds the Wasm production bundle and copies it to /docs (publishWasmToDocs), then stages all changes, auto-generates a commit message, commits, and pushes to the current branch.
argument-hint: [optional commit message]
user-invocable: true
allowed-tools:
  - Bash(./gradlew.bat:*)
  - Bash(gradlew.bat:*)
  - Bash(git status:*)
  - Bash(git diff:*)
  - Bash(git log:*)
  - Bash(git add:*)
  - Bash(git commit:*)
  - Bash(git push:*)
  - Bash(git branch:*)
  - Bash(git rev-parse:*)
---

You are publishing this Compose Multiplatform / Wasm project to GitHub Pages and then committing and pushing all changes.

**Stack context:**
- Build tool: Gradle (Windows → use `./gradlew.bat`)
- Publish task: `:composeApp:publishWasmToDocs` — compiles the Wasm production bundle and copies it to `docs/` (preserving `docs/CNAME`). GitHub Pages serves `docs/` on the `main` branch.

**Optional message argument:** $ARGUMENTS

## Steps — execute in order

### 1. Run the production build

```
./gradlew.bat :composeApp:publishWasmToDocs
```

- If the build **fails**, print the error output and **stop**. Do not stage or commit anything.
- If the build **succeeds**, continue.

### 2. Gather git context

Run in parallel:
- `git status` — see all modified and new files
- `git diff` — changes in Kotlin sources
- `git log --oneline -5` — understand commit message style

### 3. Stage all relevant changes

Run these two commands:
```
git add -u
git add docs/
```

`git add -u` stages all tracked modified files (Kotlin sources, resources, etc.).
`git add docs/` stages the regenerated production artifacts (including any new `*.wasm` files produced by the build).

**Do NOT** stage `.claude/`, `.gradle/`, `build/`, or other tooling directories.

### 4. Bail out if there is nothing to commit

If `git status --porcelain` shows nothing staged after step 3, tell the user "Nothing to commit." and stop.

### 5. Generate the commit message

If `$ARGUMENTS` is non-empty, use it as the commit title.

Otherwise, look at the staged diff (`git diff --staged`) and write a concise imperative-mood English title (≤72 chars) that describes BOTH the source changes AND the production deploy. Example patterns:
- "Update hero title and rebuild production bundle"
- "Fix projects grid layout and publish to GitHub Pages"
- "Add What Before! project card and deploy to production"

Always append:
```
Co-Authored-By: Claude Opus 4.7 <noreply@anthropic.com>
```

### 6. Commit

```
git commit -m "<title>

Co-Authored-By: Claude Opus 4.7 <noreply@anthropic.com>"
```

If a pre-commit hook fails, report the error and stop — do NOT use `--no-verify`.

### 7. Push

Get the current branch: `git rev-parse --abbrev-ref HEAD`.

Run `git push`. If the upstream is not set, run `git push --set-upstream origin <branch>`.

GitHub Pages will automatically pick up the new `docs/` content from the `main` branch within ~1 minute.

### 8. Report

Print a summary:
- Branch pushed to
- Short commit SHA and title
- Reminder: "GitHub Pages will update at www.sergiomoralbermudez.com in ~1 minute."
