import org.springframework.boot.gradle.tasks.bundling.BootJar
import org.springframework.boot.gradle.tasks.run.BootRun
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


buildscript {
    val kotlinVersion = "1.2.71"
    val springBootVersion = "2.1.1.RELEASE"

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
    java
    id("org.springframework.boot") version "2.1.1.RELEASE"
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
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.ff4j:ff4j-webapi-jersey2x:1.7.1")
    implementation("org.glassfish.jersey.inject:jersey-hk2")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks {
    "bootJar"(BootJar::class) {
        archiveName = "app.jar"
        mainClassName = "awesomeweb.AppKt"
    }

    "bootRun"(BootRun::class) {
        main = "awesomeweb.App"
        args("--spring.profiles.active=demo")
    }
}


