// https://docs.gradle.org/current/userguide/cross_project_publications.html
task("runConsoleNoAi") {
    val projectsToLoad = listOf(":mainConsole", ":rules")

    projectsToLoad.forEach { dependsOn("$it:jar") }

    exec { commandLine("rm", "-rf", "runConsoleNoAi") }
    exec { commandLine("mkdir", "runConsoleNoAi") }
    copy {
        from(projectsToLoad.map { project(it).buildDir.resolve("libs") })
        into("runConsoleNoAi")
    }
    exec { commandLine(
        "java",
        "--module-path", "runConsoleNoAi",
        "--add-modules", "ALL-MODULE-PATH",
        "-jar", "runConsoleNoAi/" + project(projectsToLoad.first()).buildDir.resolve("libs").list()?.first()
    )}
}
