import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "org.example"
version = "1.0-SNAPSHOT"

plugins {
    kotlin("jvm") version "1.9.22"
    application
    id("com.gradleup.shadow") version "8.3.3"
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21)) // Configuración para Java 21
    }
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("io.javalin:javalin:6.5.0")
    implementation("org.slf4j:slf4j-simple:2.0.7")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.18.+")
    implementation("io.github.microutils:kotlin-logging:3.0.5")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.23") // Ver si no es lo mismo que la linea 26
}

application {
    mainClass.set("com.server.MainKt")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "21"
}

tasks.withType<Jar> {
    archiveBaseName.set("com.server")
    archiveVersion.set("0.0.1")
    archiveClassifier.set("")
    manifest {
        attributes["Main-Class"] = "com.server.MainKt"
    }
}

tasks.shadowJar {
    archiveClassifier.set("")
}