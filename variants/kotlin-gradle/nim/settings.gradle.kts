rootProject.name = "nim"

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version("0.5.0")
}

include("rules")
include("mainconsole")
