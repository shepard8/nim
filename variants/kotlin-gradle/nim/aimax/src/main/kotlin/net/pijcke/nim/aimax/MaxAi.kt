package net.pijcke.nim.aimax

import net.pijcke.nim.rules.Player
import net.pijcke.nim.rules.Nim
import kotlin.math.min

class MaxAi : Player {

    override fun name() = "Max AI"

    override fun play(sticks: Int) = min(sticks, Nim.MAX_STICKS_PER_TURN)

}