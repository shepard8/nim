// https://docs.gradle.org/current/userguide/cross_project_publications.html

// The first project to load is the runner (e.g., :mainconsole, :mainjavafx, :mainnetwork)
data class NimBuild(val name : String, val projectsToLoad : List<String>) {
    val mainProject = projectsToLoad.first()
}

listOf(
    NimBuild("runConsoleNoAi", listOf(":mainconsole", ":rules")),
//    NimBuild("runConsoleAllAis", listOf(":mainConsole", ":rules", ":aione", ":aibest", ":airandom", ":aimax")),
//    NimBuild("runConsoleEasyAis", listOf(":mainConsole", ":rules", ":aione", ":aimax")),
).forEach { nimBuild ->
    tasks.register(nimBuild.name) {
        nimBuild.projectsToLoad.forEach { dependsOn("$it:jar") }

        exec { commandLine("rm", "-rf", nimBuild.name) }
        exec { commandLine("mkdir", nimBuild.name) }
        copy {
            from(nimBuild.projectsToLoad.map { project(it).buildDir.resolve("libs") })
            into(nimBuild.name)
        }
        exec { commandLine(
            "java",
            "--module-path", nimBuild.name,
            "--add-modules", "ALL-MODULE-PATH",
            "-jar", nimBuild.name + "/" + project(nimBuild.mainProject).buildDir.resolve("libs").list()?.first()
        )}
    }
}
