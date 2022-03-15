pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "Roscosmos"
include (":app")
include (":core")
include (":data")
include (":domain")
include (":screen:main")
include(":shared:ui")
include(":navigation:api")
include(":navigation:impl")
include(":screen:settings")
