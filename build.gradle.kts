import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.run.BootRun

plugins {
    val kotlinVersion = "1.3.41"
    id("org.springframework.boot") version "2.1.6.RELEASE"
    id("io.spring.dependency-management") version "1.0.7.RELEASE"
    id("com.adarshr.test-logger") version "1.7.0"
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.spring") version kotlinVersion
}

group = "io.github.alxndrhi"
version = "0.0.1-SNAPSHOT"

repositories {
    jcenter()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
        apiVersion = "1.3"
        languageVersion = "1.3"
        freeCompilerArgs = listOf("-Xjsr305=strict")
    }
}

java.sourceCompatibility = JavaVersion.VERSION_1_8

val developmentOnly: Configuration by configurations.creating

configurations {
    runtimeClasspath {
        extendsFrom(developmentOnly)
    }
}
repositories {
    mavenCentral()
    jcenter()
}

val junitVersion = "5.5.1"
val htmlDslVersion = "0.6.11"
val skrapeItVersion = "0.6.0"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    compile("org.jetbrains.kotlinx:kotlinx-html-jvm:$htmlDslVersion")
    compile("it.skrape:skrapeit-core:$skrapeItVersion")
    compile("io.github.microutils:kotlin-logging:1.7.2")

    // testing
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(module = "junit")
        exclude(module = "mockito-core")
    }
    testImplementation("org.junit.jupiter:junit-jupiter:$junitVersion")
    testCompile("it.skrape:skrapeit-mockmvc:+")
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}

apply(plugin = "com.adarshr.test-logger")

testlogger {
    setTheme("mocha")
    slowThreshold = 5000
}

tasks {
    val bootRun by getting(BootRun::class) {
        args("--spring.profiles.active=local")
        workingDir = file("src/test/resources")
    }
}
