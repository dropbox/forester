import com.vanniktech.maven.publish.MavenPublishBaseExtension
import com.vanniktech.maven.publish.SonatypeHost
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        maven("https://oss.sonatype.org/content/repositories/snapshots/")
        mavenLocal()
    }
    dependencies {
        classpath(libs.kotlin.gradle.plugin)
        classpath(libs.android.gradle.plugin)
        classpath(libs.kotlin.serialization.plugin)
        classpath(libs.gradle.maven.publish.plugin)
        classpath(libs.asm)
        classpath(libs.asm.util)
        classpath(libs.anvil.gradle.plugin)
        classpath(libs.jetbrains.compose.gradle.plugin)
    }
}

apply(plugin = "com.vanniktech.maven.publish.base")

allprojects {
    repositories {
        google()
        mavenCentral()
        mavenLocal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        maven("https://oss.sonatype.org/content/repositories/snapshots/")
    }
    group = project.property("GROUP") as String
    version = project.property("VERSION_NAME") as String

    plugins.withId("com.vanniktech.maven.publish") {
        configure<MavenPublishBaseExtension> {
            publishToMavenCentral(SonatypeHost.S01, automaticRelease = true)
        }
    }
}

plugins {
    id("org.jetbrains.compose") apply false
}