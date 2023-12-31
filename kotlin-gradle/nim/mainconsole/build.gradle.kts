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
    implementation(project(":rules"))
}

application {
    mainClass.set("net.pijcke.nim.mainconsole.MainKt")
}
tasks.jar {
    manifest {
        attributes("Main-Class" to "net.pijcke.nim.mainconsole.MainKt")
    }
}

tasks.named("compileJava", JavaCompile::class.java) {
    options.compilerArgumentProviders.add(CommandLineArgumentProvider {
        listOf("--patch-module", "nim.mainconsole=${sourceSets["main"].output.asPath}")
    })
}

kotlin {
    jvmToolchain(19)
}