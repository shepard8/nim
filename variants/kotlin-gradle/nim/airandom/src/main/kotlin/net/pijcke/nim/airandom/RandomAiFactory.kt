package net.pijcke.nim.airandom

import net.pijcke.nim.rules.Player
import net.pijcke.nim.rules.PlayerFactory

class RandomAiFactory : PlayerFactory {

    override fun build(): Player = RandomAi()

    override fun label() = "AI : Random"

}