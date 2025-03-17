rootProject.name = "multi-module-practice"
include(
    "monolithic",
    "common",
    "core",
    "board",
)

apply(from ="board/board.settings.gradle.kts")
apply(from ="core/core.settings.gradle.kts")