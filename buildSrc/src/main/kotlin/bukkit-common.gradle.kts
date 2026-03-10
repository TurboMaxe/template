import io.turbo.random.BuildConstants

plugins {
    `kotlin-dsl`
}


repositories {
    mavenCentral()
}

dependencies {
    compileOnly("org.projectlombok:lombok:1.18.38")
    annotationProcessor("org.projectlombok:lombok:1.18.38")

    compileOnly("org.jetbrains:annotations:26.0.2")
    annotationProcessor("org.jetbrains:annotations:26.0.2")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.12.2")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.12.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.12.2")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher:1.12.2")
    testCompileOnly("org.jetbrains:annotations:26.0.2")
    testCompileOnly("org.projectlombok:lombok:1.18.38")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.38")
}
tasks {
  register("printSystemProperties") {
    doLast {
        println("Plugin version: ${BuildConstants.ver}")
        println("API version: ${BuildConstants.api}")

      if (BuildConstants.ver.contains("b")) {
         println("Running in beta version of ${BuildConstants.name}") 
            }
         }
      }

  named<ProcessResources>("processResources") {
        val props = mapOf("version" to BuildConstants.ver,
                          "api" to BuildConstants.api)

        inputs.properties(props)
        filteringCharset = "UTF-8"

        filesMatching(listOf("plugin.yml", "paper-plugin.yml")) {
            expand(props)
        }
    }


   withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
        archiveFileName.set("${rootProject.name}-${project.name.replaceFirstChar{it.uppercase()}}-${BuildConstants.ver}.jar")
    }
  
   }
}

