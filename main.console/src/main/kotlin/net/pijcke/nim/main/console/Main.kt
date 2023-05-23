package net.pijcke.nim.main.console

import net.pijcke.nim.rules.Nim
import net.pijcke.nim.rules.Player
import net.pijcke.nim.rules.PlayerFactory
import java.util.*
import kotlin.system.exitProcess

private val factories = ServiceLoader.load(PlayerFactory::class.java).toList()

fun main() {
    if (factories.isEmpty()) {
        println("No player factory found. Can't start game.")
        exitProcess(1)
    }

    factories.forEachIndexed { i, playerFactory -> println("$i : ${playerFactory.label}") }

    val player1 = buildPlayer(1)
    val player2 = buildPlayer(2)

    Nim(listOf(player1, player2), 42).start()
}

private fun buildPlayer(number : Int) : Player {
    println("Enter player $number type :")
    val index = readln().toIntOrNull() ?: throw InputMismatchException("Not an integer")
    if (index < 0 || index >= factories.count())
        throw InputMismatchException("Not in range")
    return factories[index].build()
}
