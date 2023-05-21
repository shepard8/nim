package net.pijcke.nim.main.console

import net.pijcke.nim.rules.PlayerFactory
import java.util.*

fun main() {
    val factories = ServiceLoader.load(PlayerFactory::class.java)
    // Retrieve available factories
    // Ask how to build player 1
    // Ask how to build player 2
    // Create and start game
}