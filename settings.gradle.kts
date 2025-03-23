rootProject.name = "multi-module-practice"
include(
    "board-server",
    "common",
    "core"
)

project(":board-server").projectDir = file("monolithic/board-server")
apply(from ="services/board/board.settings.gradle.kts")
apply(from ="core/core.settings.gradle.kts")
