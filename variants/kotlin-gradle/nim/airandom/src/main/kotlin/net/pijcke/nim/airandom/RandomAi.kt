package net.pijcke.nim.airandom

import net.pijcke.nim.rules.Nim
import net.pijcke.nim.rules.Player
import java.util.Random
import kotlin.math.min

class RandomAi : Player {

    private val random = Random()

    override fun name(): String = "Random AI"

    override fun play(sticks: Int): Int {
        return random.nextInt(min(Nim.MAX_STICKS_PER_TURN, sticks)) + 1
    }

}