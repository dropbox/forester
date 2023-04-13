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
        classpath("com.dropbox.forester:forester:0.0.1")
        classpath("com.dropbox.forester:forester-gradle-plugin:0.0.1")
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
    group = "com.dropbox.forester"
    version = "0.0.1"
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
