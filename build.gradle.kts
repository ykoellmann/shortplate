import org.jetbrains.intellij.platform.gradle.TestFrameworkType

plugins {
    id("org.jetbrains.kotlin.jvm")
    id("org.jetbrains.changelog")
    id("org.jetbrains.intellij.platform")
}

changelog {
    version = project.version.toString()
    groups = listOf("feat", "fix", "break", "chore")
    repositoryUrl = "https://github.com/ykoellmann/shortplate"
}

intellijPlatform {
    pluginConfiguration {
        version = project.version.toString()

        ideaVersion {
            sinceBuild = "253"
        }

        changeNotes = provider {
            changelog.renderItem(
                changelog.getOrNull(project.version.toString()) ?: changelog.getUnreleased(),
                org.jetbrains.changelog.Changelog.OutputType.HTML
            )
        }
    }
}

kotlin {
    jvmToolchain(21)
}

dependencies {
    testImplementation(libs.junit)

    intellijPlatform {
        intellijIdea("2025.3.5")
        testFramework(TestFrameworkType.Platform)
    }
}

tasks {
    signPlugin {
        certificateChain = System.getenv("CERTIFICATE_CHAIN")
        privateKey = System.getenv("PRIVATE_KEY")
        password = System.getenv("PRIVATE_KEY_PASSWORD")
    }

    publishPlugin {
        token = System.getenv("PUBLISH_TOKEN")
    }
}
