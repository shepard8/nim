package net.pijcke.nim.ai.random

import net.pijcke.nim.rules.PlayerFactory

class RandomAIFactory : PlayerFactory {

    override val label = "AI : Random"

    override fun build() = RandomAI()

}