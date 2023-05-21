package net.pijcke.nim.ai.random

import net.pijcke.nim.rules.Nim
import net.pijcke.nim.rules.Player
import kotlin.math.min
import kotlin.random.Random

class RandomAI : Player {

    override val name = "Random AI"

    override fun play(sticks: Int): Int {
        return Random.nextInt(1, min(sticks, Nim.MAX_STICKS_PER_TURN))
    }

}