plugins {
    kotlin("jvm") version "1.9.10"
}

group = "net.pijcke.nim"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":rules"))
    implementation(project(":airandom"))
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.named("compileJava", JavaCompile::class.java) {
    options.compilerArgumentProviders.add(CommandLineArgumentProvider {
        listOf("--patch-module", "net.pijcke.nim.aibest=${sourceSets["main"].output.asPath}")
    })
}

kotlin {
    jvmToolchain(19)
}