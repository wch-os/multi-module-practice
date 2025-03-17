plugins {
    id("java")
}

allprojects {
    group = "org.example"

    repositories {
        mavenCentral()
    }
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}
