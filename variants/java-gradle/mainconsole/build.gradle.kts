plugins {
    id("java")
}

group = "net.pijcke.nim"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":rules"))
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "net.pijcke.nim.mainconsole.Main"
    }
}

tasks.test {
    useJUnitPlatform()
}