plugins {
    id("java")
    id("java-library")
    id("org.springframework.boot") version "3.4.3"
    id("io.spring.dependency-management") version "1.1.7"
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

dependencies {
    // module
    api(project(":board")) // board 모듈의 build.gradle.kts 파일을 참조한다.
    implementation(project(":common"))
    implementation(project(":core"))

    runtimeOnly("com.h2database:h2")
    implementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
