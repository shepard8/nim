// https://docs.gradle.org/current/userguide/cross_project_publications.html

// The first project to load is the runner (e.g., :mainconsole, :mainjavafx, :mainnetwork)
data class NimBuild(val name : String, val projectsToLoad : List<String>) {
    val mainProject = projectsToLoad.first()
}

listOf(
    NimBuild("runConsoleNoPlayer", listOf(":mainconsole", ":rules")),
    NimBuild("runConsoleNoAi", listOf(":mainconsole", ":rules", ":humanconsole")),
    NimBuild("runConsoleEasyAis", listOf(":mainconsole", ":rules", ":humanconsole", ":aione", ":aimax")),
    NimBuild("runConsoleAllAis", listOf(":mainconsole", ":rules", ":humanconsole", ":aione", ":aibest", ":airandom", ":aimax")),
).forEach { nimBuild ->
    tasks.register(nimBuild.name) {
        nimBuild.projectsToLoad.forEach { dependsOn("$it:build") }

        doLast {
            exec { commandLine("rm", "-rf", nimBuild.name) }
            exec { commandLine("mkdir", nimBuild.name) }
            copy {
                from(nimBuild.projectsToLoad.map { project(it).buildDir.resolve("libs") })
                into(nimBuild.name)
            }
            copy {
                from("/home/shepard/.m2/repository/org/jetbrains/kotlin/kotlin-stdlib/1.8.21/kotlin-stdlib-1.8.21.jar")
                into(nimBuild.name)
            }
            exec {
                standardInput = System.`in`

                commandLine(
                    "java",
                    "--module-path", nimBuild.name,
                    "--add-modules", "ALL-MODULE-PATH",
                    "-jar", nimBuild.name + "/" + project(nimBuild.mainProject).buildDir.resolve("libs").list()?.first()
                )
            }
        }
    }
}
