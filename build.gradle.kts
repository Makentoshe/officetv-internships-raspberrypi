plugins {
    kotlin("jvm") version "1.4.31"
}

group = "com.makentoshe"
version = "1.0-SNAPSHOT"

repositories {
    google()
    jcenter()
    mavenCentral()}

dependencies {

    implementation(kotlin("stdlib"))

    // JUnit 4 (unit test framework)
    // https://github.com/junit-team/junit4
    testImplementation("junit:junit:4.12")
}
