import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    val kotlinVersion = "1.3.41"
    kotlin("jvm") version kotlinVersion apply false
    id("org.jetbrains.kotlin.plugin.spring") version kotlinVersion apply false
    id("com.adarshr.test-logger") version "1.7.0"
}

allprojects {
    group = "rocks.shaped-like"
    version = "0.0.1-SNAPSHOT"

    repositories {
        mavenLocal()
        mavenCentral()
        jcenter()
    }

    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "com.adarshr.test-logger")

    testlogger {
        setTheme("mocha")
        slowThreshold = 5000
    }

    tasks {
        withType<KotlinCompile> {
            kotlinOptions {
                jvmTarget = "1.8"
                apiVersion = "1.3"
                languageVersion = "1.3"
                freeCompilerArgs = listOf("-Xjsr305=strict")
            }
        }

        withType<Test>().configureEach {
            useJUnitPlatform()
        }
    }
}
