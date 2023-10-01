rootProject.name = "nim"

plugins {
    // https://docs.gradle.org/current/userguide/toolchains.html
    id("org.gradle.toolchains.foojay-resolver-convention") version("0.5.0")
}

include("rules")
include("mainconsole")
include("humanconsole")
include("airandom")
include("aione")
include("aimax")
include("aibest")
