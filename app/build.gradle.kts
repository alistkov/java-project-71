import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    application
    jacoco
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
    implementation(libs.jackson.dataformat.yaml)
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

testing {
    suites {
        named<JvmTestSuite>("test") {
            useJUnitJupiter(libs.versions.junit.get())
        }
    }
}

tasks.test {
    testLogging {
        showStandardStreams = true
        events(
            TestLogEvent.FAILED,
            TestLogEvent.PASSED,
            TestLogEvent.SKIPPED,
            TestLogEvent.STANDARD_OUT,
            TestLogEvent.STANDARD_ERROR,
        )
        exceptionFormat = TestExceptionFormat.FULL
        showExceptions = true
        showCauses = true
        showStackTraces = true
    }
}

tasks.jacocoTestReport {
    dependsOn(tasks.test)
    reports {
        xml.required.set(true)
        html.required.set(true)
    }
}

tasks.test { finalizedBy(tasks.jacocoTestReport) }

tasks.jacocoTestCoverageVerification {
    dependsOn(tasks.jacocoTestReport)
    violationRules {
        rule {
            limit {
                counter = "INSTRUCTION"
                value = "COVEREDRATIO"
                minimum = "0.80".toBigDecimal()
            }
        }
    }
    classDirectories.setFrom(
        sourceSets.main.get().output.asFileTree.matching {
            exclude("hexlet/code/App.class")
        }
    )
}

tasks.check { dependsOn(tasks.jacocoTestCoverageVerification) }

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}
