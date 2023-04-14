@file:Suppress("UnstableApiUsage")

import com.vanniktech.maven.publish.GradlePlugin
import com.vanniktech.maven.publish.JavadocJar
import com.vanniktech.maven.publish.MavenPublishBaseExtension

plugins {
    id("org.jetbrains.kotlin.jvm")
    id("org.jetbrains.kotlin.plugin.serialization")
    id("java-gradle-plugin")
    id("com.vanniktech.maven.publish.base")
}

dependencies {
    compileOnly(gradleApi())
    implementation(libs.kotlin.gradle.plugin)
    compileOnly(libs.android.gradle.plugin)
    implementation(libs.kotlinx.serialization.core)
    implementation(libs.kotlinx.serialization.json)
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.8.10")
    implementation(project(":forester"))
}



gradlePlugin {
    plugins {
        create("forester") {
            id = "com.dropbox.forester.plugin"
            displayName = "forester"
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

configure<MavenPublishBaseExtension> {
    configure(
        GradlePlugin(
            javadocJar = JavadocJar.Empty(), sourcesJar = true
        )
    )
}