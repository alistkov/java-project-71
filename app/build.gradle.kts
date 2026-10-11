import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

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

testing {
    suites {
        val test by getting(JvmTestSuite::class) {
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

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}
