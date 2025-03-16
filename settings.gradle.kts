rootProject.name = "multi-module-practice"
include("board", "monolithic", "common", "core")
include("board:api")
findProject(":board:api")?.name = "api"
include("board:application")
findProject(":board:application")?.name = "application"
