package net.pijcke.nim.aibest

import net.pijcke.nim.rules.Player
import net.pijcke.nim.rules.PlayerFactory

class BestAiFactory : PlayerFactory {

    override fun label() = "AI : Best"

    override fun build(): Player {
        return BestAi()
    }

}