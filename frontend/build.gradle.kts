plugins {
    base
    id("com.github.node-gradle.node") version "2.0.0"
}

node {
    version = "12.7.0"
    yarnVersion = "1.17.3"
}

val check by tasks.getting  {
    dependsOn("yarn_test")
}

val bundledReactApp = file("$buildDir/bundle.js")
val artifactToPublish = artifacts.add("archives", bundledReactApp) {
    type = "js"
    builtBy("yarn_bundle")
}
