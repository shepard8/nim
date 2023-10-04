plugins {
    kotlin("jvm") version "1.9.10"
    application
}

group = "net.pijcke.nim"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    runtimeOnly(project(":rules"))
    runtimeOnly(project(":mainconsole"))
    runtimeOnly(project(":humanconsole"))
    runtimeOnly(project(":aibest"))
    runtimeOnly(project(":aimax"))
    runtimeOnly(project(":aione"))
    runtimeOnly(project(":airandom"))
}

application {
    mainClass.set("net.pijcke.nim.mainconsole.MainKt")
}

tasks.named("run", JavaExec::class.java) {
    standardInput = System.`in`
    jvmArgumentProviders.add(CommandLineArgumentProvider {
        listOf("--module-path", classpath.asPath, "--add-modules", "ALL-MODULE-PATH")
    })
}
