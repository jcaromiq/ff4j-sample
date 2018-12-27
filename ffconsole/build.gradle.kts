import org.jetbrains.kotlin.gradle.tasks.KotlinCompile



buildscript {
    val kotlinVersion = "1.2.71"
    val springBootVersion = "1.5.15.RELEASE"

    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:$springBootVersion")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("org.jetbrains.kotlin:kotlin-allopen:$kotlinVersion")
    }
}


repositories {
    mavenCentral()
    jcenter()
}
plugins {
    application
    java
    id("org.springframework.boot") version "1.5.15.RELEASE"
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

apply {
    plugin("kotlin")
    plugin("kotlin-spring")
    plugin("org.springframework.boot")
    plugin("io.spring.dependency-management")
}

dependencies {
    compile(kotlin("stdlib"))
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    compile("org.ff4j:ff4j-web:1.7.3")
    compile("org.ff4j:ff4j-spring-boot-web-api:1.7.3")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}



