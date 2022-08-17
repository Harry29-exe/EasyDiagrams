import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.7.2"
    id("io.spring.dependency-management") version "1.0.12.RELEASE"
    id("org.openapi.generator") version "6.0.1"

    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
    kotlin("plugin.jpa") version "1.6.21"
}

group = "com.easydiagrams"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
//    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.springdoc:springdoc-openapi-ui:1.6.9")

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

openApiGenerate {
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