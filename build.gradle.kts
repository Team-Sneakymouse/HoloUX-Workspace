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
        maven("https://maven.sneakyrp.com/releases")
    }
}

val characterManagerPlugin by configurations.creating
val sneakyUtilsPlugin by configurations.creating

dependencies {
    characterManagerPlugin("io.github.team-sneakymouse:sneakycharactermanager:2026.10.09-84db8a554af1")
    sneakyUtilsPlugin("io.github.team-sneakymouse:sneakyutils:2026.10.18-657d452bd6f4")
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
        pluginJars.from(characterManagerPlugin)
        pluginJars.from(sneakyUtilsPlugin)
    }
}
