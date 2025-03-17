rootProject.name = "multi-module-practice"
include(
    "monolithic",
    "common",
    "core",
    "board",
)

apply(from ="board/board.settings.gradle.kts")