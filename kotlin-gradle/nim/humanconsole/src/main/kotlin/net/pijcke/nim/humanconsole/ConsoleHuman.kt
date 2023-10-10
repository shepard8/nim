package net.pijcke.nim.humanconsole

import net.pijcke.nim.rules.Player
import java.util.*

class ConsoleHuman(private val name: String) : Player {

    private val scanner = Scanner(System.`in`)

    override fun name() = name

    override fun play(sticks: Int): Int {
        println("$name, how many sticks do you want to remove ($sticks remaining)?")
        return scanner.nextInt()
    }

    override fun message(message: String) {
        println("message for $name: $message")
    }

}
