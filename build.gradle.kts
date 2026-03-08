plugins {
    kotlin("jvm") version "1.9.21" apply false
    id("xyz.jpenilla.run-paper") version "3.0.2"
}

allprojects {
    group = "com.sneakymannequins"
    version = "1.0.0"

    repositories {
        mavenCentral()
        maven("https://repo.papermc.io/repository/maven-public/")
    }
}

evaluationDependsOn(":SneakyHolos")
evaluationDependsOn(":SneakyMannequins-Plugin")

tasks {
    runServer {
        minecraftVersion("1.21.4")
        pluginJars.from(project(":SneakyMannequins-Plugin").tasks.named("jar"))
    }
}
