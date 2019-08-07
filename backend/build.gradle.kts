import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.1.6.RELEASE"
    id("io.spring.dependency-management") version "1.0.7.RELEASE"
    kotlin("plugin.spring")
    kotlin("jvm")
    id("com.bmuschko.docker-spring-boot-application") version "4.10.0"
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
val frontendBundle: Configuration by configurations.creating

configurations {
    runtimeClasspath {
        extendsFrom(developmentOnly)
    }
}

val junitVersion = "5.5.1"
val htmlDslVersion = "0.6.11"
val skrapeItVersion = "0.6.0"

dependencies {
    frontendBundle(project(path = ":frontend", configuration = "archives"))
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
    testImplementation("it.skrape:skrapeit-mockmvc:+")
    testImplementation("io.strikt:strikt-core:0.21.1")
    testImplementation("io.mockk:mockk:1.9.3")
}


tasks {
    withType<Test>().configureEach {
        useJUnitPlatform()
    }

    bootRun {
        args("--spring.profiles.active=local")
    }
}

val copyFrontend by tasks.creating(Copy::class) {
    from(frontendBundle)
    destinationDir = file("$buildDir/frontend/static")
}

sourceSets {
    main {
        java {
            output.dir("$buildDir/frontend", "builtBy" to copyFrontend)
        }
    }
}

docker {
    springBootApplication {
        baseImage.set("openjdk:8-alpine")
        ports.set(listOf(8080, 8080))
        tag.set("${rootProject.name}:prod")
        jvmArgs.set(listOf("-Dspring.profiles.active=production", "-Xmx2048m"))
    }
}
