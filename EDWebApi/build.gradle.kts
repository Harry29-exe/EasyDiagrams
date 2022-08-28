import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.openapitools.generator.gradle.plugin.tasks.GenerateTask

plugins {
    id("org.springframework.boot") version "2.7.2"
    id("io.spring.dependency-management") version "1.0.12.RELEASE"
    id("org.openapi.generator") version "6.0.1"
    id("org.flywaydb.flyway") version "9.1.6"

    kotlin("jvm") version "1.7.10"
    kotlin("plugin.spring") version "1.7.10"
    kotlin("plugin.jpa") version "1.7.10"
}

group = "com.easydiagrams"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

val exposedVersion = "0.39.2"
dependencies {
//    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.springdoc:springdoc-openapi-ui:1.6.9")
    implementation("org.jetbrains.exposed:exposed-core:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-dao:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposedVersion")
    implementation("org.postgresql:postgresql:42.4.1")

    developmentOnly("org.springframework.boot:spring-boot-devtools")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test")
}


tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
    dependsOn(tasks.openApiGenerate)
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<GenerateTask> {
    generatorName.set("kotlin-spring")

    inputSpec.set("$rootDir/src/main/resources/api/EDWebApi.yaml")
    outputDir.set("$rootDir/")
    apiPackage.set("com.easydiagrams.edwebapi.generated.api")
    invokerPackage.set("com.easydiagrams.edwebapi.generated")
    modelPackage.set("com.easydiagrams.edwebapi.generated.model")

    templateDir.set("$rootDir/src/main/resources/gen/")
    generateApiTests.set(false)
    modelNameSuffix.set("DTO")
    configOptions.set(
        mapOf(
            "dateLibrary" to "java8",
            "gradleBuildFile" to "false",
            "interfaceOnly" to "true",
            "BasePackage" to "com.easydiagrams.edwebapi.generated",
            "documentationProvider" to "springdoc",
            "useTags" to "true"
        )
    )
}

tasks.withType<GenerateTask> {
    generatorName.set("typescript-fetch")

    inputSpec.set("$rootDir/src/main/resources/api/EDWebApi.yaml")
    outputDir.set("$rootDir/../EDWebApp/src/generated/")
}

flyway {
    url = "jdbc:postgresql://localhost:5432/postgres"
    user = "postgres"
    password = "123"
//    schemas = ['schema1', 'schema2', 'schema3']
//    placeholders = [
//        "keyABC': 'valueXYZ",
//    "otherplaceholder': 'value123"
//    ]
}