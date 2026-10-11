plugins {
    application
    alias(libs.plugins.versions)
    alias(libs.plugins.spotless)
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

application { mainClass = "hexlet.code.App" }

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.picocli)
    implementation(libs.databind)
}

spotless {
    java {
        importOrder()
        googleJavaFormat().aosp()
        formatAnnotations()
        removeUnusedImports()
        leadingTabsToSpaces(4)
        endWithNewline()
    }
}
