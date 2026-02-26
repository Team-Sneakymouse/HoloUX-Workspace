plugins {
    kotlin("jvm") version "1.9.21" apply false
    id("xyz.jpenilla.run-paper") version "3.0.2" apply false
}

allprojects {
    group = "com.sneakymannequins"
    version = "1.0.0"

    repositories {
        mavenCentral()
        maven("https://repo.papermc.io/repository/maven-public/")
    }
}
