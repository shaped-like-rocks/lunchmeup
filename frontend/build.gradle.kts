plugins {
    java
    id("com.github.node-gradle.node") version "2.0.0"
}

node {
    version = "12.7.0"
    yarnVersion = "1.17.3"
}

val check by tasks.getting  {
    dependsOn("yarn_test")
}

val jar by tasks.getting(Jar::class)  {
    archiveFileName.set("${project.name}.jar")
    dependsOn("yarn_bundle")
    from(fileTree("dist"))
    into("META-INF/resources")
}
