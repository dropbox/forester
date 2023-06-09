@file:Suppress("UnstableApiUsage")

import com.vanniktech.maven.publish.SonatypeHost

plugins {
    id("org.jetbrains.kotlin.jvm")
    id("org.jetbrains.kotlin.plugin.serialization")
    id("java-gradle-plugin")
    id("com.vanniktech.maven.publish")
    `maven-publish`
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

gradlePlugin {
    plugins {
        create("forester") {
            id = "com.dropbox.forester.plugin"
            displayName = "Forester"
            description = "Generates architecture diagrams based on annotations and code structure"
            implementationClass = "com.dropbox.forester.plugin.ForesterPlugin"
        }
    }
}

mavenPublishing {
    publishToMavenCentral(SonatypeHost.S01)
    signAllPublications()
}