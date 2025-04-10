import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "org.example"
version = "1.0-SNAPSHOT"

plugins {
    kotlin("jvm") version "1.9.22"  // Usa la última versión de Kotlin
    application  // Plugin para aplicaciones Java/Kotlin
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
    implementation(kotlin("stdlib"))
    implementation("io.github.microutils:kotlin-logging:3.0.5")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "21"
}