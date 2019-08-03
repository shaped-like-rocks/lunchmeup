plugins {
    base

    val kotlinVersion = "1.3.41"
    id("org.jetbrains.kotlin.jvm") version kotlinVersion apply false
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

    apply(plugin = "com.adarshr.test-logger")

    testlogger {
        setTheme("mocha")
        slowThreshold = 5000
    }
}