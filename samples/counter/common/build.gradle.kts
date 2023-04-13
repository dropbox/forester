plugins {
    id("org.jetbrains.kotlin.multiplatform")
    id("org.jetbrains.kotlin.plugin.serialization")
    id("com.dropbox.forester.plugin")
}

kotlin {

    jvm()

    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.kotlinx.serialization.core)
                implementation(project(":forester-gradle-plugin"))
                implementation(project(":forester"))
            }
        }
    }
}
forester {
    outputDir = "docs"
}
