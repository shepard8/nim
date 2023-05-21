package net.pijcke.nim.ai.max

import net.pijcke.nim.rules.Nim
import net.pijcke.nim.rules.Player
import kotlin.math.min

class MaxAI : Player {

    override val name = "Random AI"

    override fun play(sticks: Int): Int {
        return min(sticks, Nim.MAX_STICKS_PER_TURN)
    }

}