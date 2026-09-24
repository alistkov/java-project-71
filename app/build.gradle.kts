plugins {
    application
    alias(libs.plugins.versions)
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

application { mainClass = "hexlet.code.App" }

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.picocli)
}
