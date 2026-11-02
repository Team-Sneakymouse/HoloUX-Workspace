# Agent instructions (HoloUX-Workspace)

This Gradle workspace builds two submodules together: SneakyHolos (a library) and SneakyMannequins (the Paper plugin that bundles SneakyHolos and gets deployed). Inside a submodule, its own `AGENTS.md` also applies.

## Shipping a SneakyHolos change

The workspace builds SneakyMannequins against SneakyHolos source, but CI builds SneakyMannequins on its own, against the `sneakyholos` version pinned in `SneakyMannequins/build.gradle.kts`. A SneakyHolos fix reaches the server only after all three steps:

1. Push SneakyHolos `main`. Its Publish Maven workflow publishes `sneakyholos:<yyyy.MM.dd>-<12-char commit hash>`.
2. Bump the pin in SneakyMannequins, run `./gradlew build` from `SneakyMannequins/` (a standalone build, like CI), and push `main`.
3. Commit the updated submodule pointers in this workspace.

## Submodule checkouts

Submodules are checked out on a detached HEAD, often behind `origin/main`. Before committing in one, run `git fetch && git checkout -B main origin/main`. Uncommitted edits carry over.

## Windows test failures

On Windows, two `PartManagementTest` tests fail with `UnsupportedOperationException` from `Files.setPosixFilePermissions`. That is a platform limit, not a regression.
