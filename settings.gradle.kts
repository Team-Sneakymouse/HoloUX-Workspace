pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://repo.papermc.io/repository/maven-public/")
    }
}

rootProject.name = "HoloUX-Workspace"

include(":SneakyHolos")
project(":SneakyHolos").projectDir = file("SneakyHolos")

include(":SneakyMannequins-Plugin")
project(":SneakyMannequins-Plugin").projectDir = file("SneakyMannequins")
