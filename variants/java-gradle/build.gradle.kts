// https://docs.gradle.org/current/userguide/cross_project_publications.html

// The first project to load is the runner (e.g., :mainconsole, :mainjavafx, :mainnetwork)
data class NimBuild(val name : String, val projectsToLoad : List<String>)

listOf(
    NimBuild("runConsoleNoAi", listOf(":mainconsole", ":rules")),
//    NimBuild("runConsoleAllAis", listOf(":mainConsole", ":rules", ":aione", ":aibest", ":airandom", ":aimax")),
//    NimBuild("runConsoleEasyAis", listOf(":mainConsole", ":rules", ":aione", ":aimax")),
).forEach {
    tasks.register(it.name) {
        it.projectsToLoad.forEach { dependsOn("$it:jar") }

        exec { commandLine("rm", "-rf", "runConsoleNoAi") }
        exec { commandLine("mkdir", "runConsoleNoAi") }
        copy {
            from(it.projectsToLoad.map { project(it).buildDir.resolve("libs") })
            into("runConsoleNoAi")
        }
        exec { commandLine(
            "java",
            "--module-path", "runConsoleNoAi",
            "--add-modules", "ALL-MODULE-PATH",
            "-jar", "runConsoleNoAi/" + project(it.projectsToLoad.first()).buildDir.resolve("libs").list()?.first()
        )}
    }
}
