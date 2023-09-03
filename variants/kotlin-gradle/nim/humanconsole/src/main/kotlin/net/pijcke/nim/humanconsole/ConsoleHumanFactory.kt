package net.pijcke.nim.humanconsole

import net.pijcke.nim.rules.Player
import net.pijcke.nim.rules.PlayerFactory
import java.util.*

class ConsoleHumanFactory : PlayerFactory {

    private val scanner = Scanner(System.`in`)

    override fun label() = "Human : Console"

    override fun build() : Player {
        println("Please enter player's name : ")
        val name = scanner.nextLine()
        return ConsoleHuman(name)
    }

}