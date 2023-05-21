package net.pijcke.nim.ai.max

import net.pijcke.nim.rules.PlayerFactory

class MaxAIFactory : PlayerFactory {

    override val label = "AI : Max"

    override fun build() = MaxAI()

}