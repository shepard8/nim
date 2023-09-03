package net.pijcke.nim.aione

import net.pijcke.nim.rules.Player
import net.pijcke.nim.rules.PlayerFactory

class OneAiFactory : PlayerFactory {

    override fun label() = "AI : One"

    override fun build(): Player {
        return OneAi()
    }

}