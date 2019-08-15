plugins {
    kotlin("jvm")
    id("com.github.node-gradle.node") version "2.0.0"
}

node {
    version = "12.7.0"
    yarnVersion = "1.17.3"
}

val yarn_test by tasks.getting  {
    dependsOn("yarn_install")
}

val check by tasks.getting  {
    dependsOn("yarn_test")
}

val build by tasks.getting  {
    dependsOn("yarn_bundle")
}

val jar by tasks.getting(Jar::class)  {
    archiveFileName.set("${project.name}.jar")
    from(fileTree("dist"))
    into("META-INF/resources")
}
