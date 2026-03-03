import io.turbo.random.BuildConstants

plugins {
    kotlin("jvm") version "2.3.20-RC"
    id("com.gradleup.shadow") version "8.3.0"
    id("xyz.jpenilla.run-paper") version "2.3.1"
}

version = BuildConstants.VERSION


repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/") {
        name = "papermc-repo"
    }
    maven {
        url = uri("https://jitpack.io")
    }
    maven {
        url = uri("https://repo.clojars.org/")
    }
    maven {
        url = uri("https://maven.pkg.github.com/Exlll/ConfigLib")
    }
    maven {
        url = uri("https://repo.lucko.me/")
    }

}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.21.1-R0.1-SNAPSHOT")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("dev.triumphteam:triumph-gui:3.1.13")
    compileOnly("com.github.MilkBowl:VaultAPI:1.7")
    implementation("com.github.puregero:multilib:1.2.5")
    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")
    implementation("de.exlll:configlib-yaml:4.8.0")

}

tasks {
  runServer {
    minecraftVersion("1.21")
  }
}

val targetJavaVersion = 21

kotlin {
    jvmToolchain(targetJavaVersion)
}

tasks.build {
    dependsOn("shadowJar")
}

tasks.shadowJar {
    relocate("com.github.puregero.multilib", "io.turbo.random.multilib")
    relocate("dev.triumphteam.gui", "io.turbo.random.gui")
    relocate("me.lucko.helper", "io.turbo.random.libs.lucko")
    mergeServiceFiles()
}

tasks.processResources {
    val props = mapOf(
        "name" to BuildConstants.NAME,
        "version" to BuildConstants.VERSION,
        "main" to BuildConstants.MAIN,
        "apiversion" to BuildConstants.API
    )
    inputs.properties(props)
    filesMatching("plugin.yml") { expand(props) }
  }
}
