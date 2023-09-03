package net.pijcke.nim.mainconsole

import net.pijcke.nim.rules.Nim
import net.pijcke.nim.rules.Player
import net.pijcke.nim.rules.PlayerFactory
import java.util.Scanner
import java.util.ServiceLoader
import kotlin.system.exitProcess

val factories : List<PlayerFactory> = ServiceLoader.load(PlayerFactory::class.java).map { it }

val scanner = Scanner(System.`in`)

fun main() {
    if (factories.isEmpty()) {
        println("No player factory found. Can't start game.")
        exitProcess(1)
    }

    factories.forEachIndexed { i, pf -> println("$i : $pf") }

    val player1 = buildPlayer(1)
    val player2 = buildPlayer(2)

    Nim(player1, player2, 42).start()
}

fun buildPlayer(number: Int): Player {
    println("Enter player $number type : ")
    return scanner.nextInt()
        .takeIf { it in factories.indices }
        ?.let { index -> factories[index].build() }
        ?: buildPlayer(number)
}
