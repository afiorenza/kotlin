group = "org.example"
version = "1.0-SNAPSHOT"

plugins {
    kotlin("jvm") version "2.0.20"
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
    implementation("org.jetbrains.kotlin:kotlin-stdlib:2.0.20")
    implementation("org.postgresql:postgresql:42.7.4")
    implementation("org.jetbrains.exposed:exposed-core:0.60.0")
    implementation("org.jetbrains.exposed:exposed-jdbc:0.60.0")
    implementation("io.github.cdimascio:dotenv-kotlin:6.4.1")
}

application {
    mainClass.set("com.server.MainKt")
}

tasks.test {
    useJUnitPlatform()
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