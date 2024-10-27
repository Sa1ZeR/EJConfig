import org.gradle.jvm.tasks.Jar

plugins {
    id("com.github.johnrengelman.shadow") version "8.1.0"
    kotlin("jvm") version "2.0.0"
    application
    `maven-publish`
}

group = "com.sa1zer"
version = "1.3.0-SNAPSHOT"

repositories {
    mavenCentral()
}

publishing {
    publications {
        create<MavenPublication>("mavenKotlin") {
            from(components["java"])
            pom {
                name.set("EJConfig")
                description.set("Simple yaml/json configuration")
                url.set("https://github.com/Sa1ZeR/EJConfig")
                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                developers {
                    developer {
                        id.set("Sa1ZeR")
                        name.set("Sergey")
                    }
                }
            }
        }
    }
}

dependencies {
    implementation("com.fasterxml.jackson.core:jackson-core:2.17.2")
    implementation("com.fasterxml.jackson.core:jackson-annotations:2.17.2")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.17.2")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.17.2")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.17.2")

    testImplementation(kotlin("test"))
}

application {
    mainClass.set("com.sa1zer.ejconfig.MainKt")
}

tasks.test {
    useJUnitPlatform()
}

tasks.assemble { dependsOn(tasks.shadowJar) }

java {
    withSourcesJar()
    withJavadocJar()
}

kotlin {
    jvmToolchain(17)
}