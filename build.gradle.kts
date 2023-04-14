import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        google()
        mavenCentral()
        maven("https://oss.sonatype.org/content/repositories/snapshots/")
        mavenLocal()
    }
    dependencies {
        classpath(libs.kotlin.gradle.plugin)
        classpath(libs.android.gradle.plugin)
        classpath(libs.kotlin.serialization.plugin)
        classpath("org.ow2.asm:asm:9.4")
        classpath("org.ow2.asm:asm-util:9.4")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        mavenLocal()
    }
    group = project.property("GROUP") as String
    version = project.property("VERSION_NAME") as String
}

subprojects {
    tasks.withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "17"
        }
    }
}

plugins {
    kotlin("multiplatform") apply false
    kotlin("android") apply false
    id("com.android.application") apply false
    id("com.android.library") apply false
}
