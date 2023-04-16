pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        mavenLocal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }

    plugins {
        id("org.jetbrains.compose").version(extra["compose.version"] as String)
    }
}

rootProject.name = "forester"

include(
    ":forester",
    ":forester-gradle-plugin",
    ":forester-graph-plugin",
    ":android:app",
    ":android:common:api",
    ":android:common:scoping",
    ":android:feat:account_tab",
    ":android:feat:pokedex_tab",
    ":android:lib:dig"
)