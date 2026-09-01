import org.gradle.jvm.toolchain.JavaToolchainService

plugins {
    id("java-base")
    kotlin("jvm") version "2.4.10" apply false
    id("io.papermc.paperweight.userdev") version "2.0.0-beta.22" apply false
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
        minecraftVersion("26.2")
        javaLauncher.set(project.extensions.getByType<JavaToolchainService>().launcherFor {
            languageVersion.set(JavaLanguageVersion.of(25))
        })
        jvmArgs("-Dcom.mojang.eula.agree=true")
        pluginJars.from(project(":SneakyMannequins-Plugin").tasks.named("jar"))
        pluginJars.from(files("../SneakyCharacterManager-Paper/build/libs/SneakyCharacterManager.jar"))
    }
}
