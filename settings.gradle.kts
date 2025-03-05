pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS) // Change to PREFER_SETTINGS
    repositories {
        google()
        mavenCentral()
        maven ( "https://jitpack.io" )

    }
}

rootProject.name = "MealMate-Demo"
include(":app")
 