@file:Suppress("UnstableApiUsage")

plugins {
    id("org.jetbrains.kotlin.jvm")
    id("org.jetbrains.kotlin.plugin.serialization")
    id("java-gradle-plugin")
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
