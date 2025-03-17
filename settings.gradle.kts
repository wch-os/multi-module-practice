rootProject.name = "multi-module-practice"
include("board",
    "monolithic",
    "common",
    "core",
    "board:api",
    "board:application"
)
findProject(":board:api")?.name = "api"
findProject(":board:application")?.name = "application"
