package net.pijcke.nim.aione

import net.pijcke.nim.rules.Player

class OneAi : Player {

    override fun name() = "One AI"

    override fun play(sticks: Int) = 1

}