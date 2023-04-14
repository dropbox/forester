plugins {
    id("org.jetbrains.kotlin.multiplatform")
    id("org.jetbrains.kotlin.plugin.serialization")
    id("maven-publish")
}


kotlin {
    jvm()

    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.kotlinx.serialization.core)
                implementation(libs.kotlinx.serialization.json)
                implementation("org.jetbrains.kotlin:kotlin-reflect:1.8.10")
            }
        }
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}


publishing {
    publications {
        create<MavenPublication>("foresterMavenPublication") {
            from(components["kotlin"])
            groupId = group.toString()
            artifactId = "forester"
            version = version.toString()
        }
    }
}