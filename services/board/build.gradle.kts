plugins {
    id("java")
    id("java-library")
    id("org.springframework.boot") version "3.4.1"
    id("io.spring.dependency-management") version "1.1.7"
}

version = "1.0-SNAPSHOT"

dependencies {
    // modules
    api(project(":board:application"))
    api(project(":board:board:board-domain"))
    api(project(":board:board:board-domain-driven"))
}
