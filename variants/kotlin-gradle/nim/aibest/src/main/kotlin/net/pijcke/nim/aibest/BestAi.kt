package net.pijcke.nim.aibest

import net.pijcke.nim.airandom.RandomAi
import net.pijcke.nim.rules.Nim
import net.pijcke.nim.rules.Player

class BestAi : Player {

    companion object {
        private const val MAX = Nim.MAX_STICKS_PER_TURN
        private const val MAX_PLUS_ONE = MAX + 1
    }

    private val fallbackStrategy = RandomAi()

    override fun name() = "Best AI"

    override fun play(sticks: Int) : Int {
        if (sticks == 1) return 1
        if (sticks % MAX_PLUS_ONE == 1) return fallbackStrategy.play(sticks)
        return ((sticks % MAX_PLUS_ONE) + MAX) % MAX_PLUS_ONE
    }

}
