@file:Suppress("UnstableApiUsage")

plugins {
    id("org.jetbrains.kotlin.jvm")
    id("org.jetbrains.kotlin.plugin.serialization")
    id("java-gradle-plugin")
    id("com.vanniktech.maven.publish")
}

dependencies {
    compileOnly(gradleApi())
    implementation(libs.kotlin.gradle.plugin)
    compileOnly(libs.android.gradle.plugin)
    implementation(libs.kotlinx.serialization.core)
    implementation(libs.kotlinx.serialization.json)
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.8.10")
    implementation(project(":forester"))
    implementation(libs.dagger)
    implementation(libs.dagger.spi)
}


gradlePlugin {
    plugins {
        create("forester") {
            id = "com.dropbox.forester.plugin"
            displayName = "Forester"
            description = "Generates architecture diagrams based on code structure and annotations"
            implementationClass = "com.dropbox.forester.plugin.ForesterPlugin"
        }
    }
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = "11"
        }
    }
    compileTestKotlin {
        kotlinOptions {
            jvmTarget = "11"
        }
    }
}
