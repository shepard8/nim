package net.pijcke.nim.aimax

import net.pijcke.nim.rules.Player
import net.pijcke.nim.rules.PlayerFactory

class MaxAiFactory : PlayerFactory {

    override fun label() = "AI : Max"

    override fun build(): Player {
        return MaxAi()
    }

}