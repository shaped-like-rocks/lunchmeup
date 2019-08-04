plugins {
    id("com.github.node-gradle.node") version "2.0.0"
}

node {
    version = "12.7.0"
    yarnVersion = "1.17.3"
}

tasks {

    register("bundle") {
        description = "bundle react app to browser understandable vanilla js"
        dependsOn("yarn_bundle")
    }

    register("check") {
        description = "Start all frontend tests"
        dependsOn("yarn_test")
    }
}