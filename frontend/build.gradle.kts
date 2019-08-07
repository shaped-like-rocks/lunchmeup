plugins {
    base
    java
    id("com.github.node-gradle.node") version "2.0.0"
}

node {
    version = "12.7.0"
    yarnVersion = "1.17.3"
}

val check: Task by tasks.getting  {
    dependsOn("yarn_test")
}

val webjar by tasks.creating(Jar::class)  {
    archiveFileName.set("${project.name}.jar")
    dependsOn("yarn_bundle")
    from(fileTree("dist"))
    into(file("$buildDir/META-INF/resources"))
}

val bundledReactApp = file("$projectDir/dist/bundle.js")
val artifactToPublish = artifacts.add("archives", bundledReactApp) {
    type = "js"
    builtBy("yarn_bundle")
}
