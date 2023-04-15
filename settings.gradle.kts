pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        mavenLocal()
    }
}

rootProject.name = "forester"

include(
    ":forester",
    ":forester-gradle-plugin",
    ":forester-graph-plugin"
)