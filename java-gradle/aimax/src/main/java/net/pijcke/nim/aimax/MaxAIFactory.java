package net.pijcke.nim.aimax;

import net.pijcke.nim.rules.Player;
import net.pijcke.nim.rules.PlayerFactory;

public class MaxAIFactory implements PlayerFactory {

    @Override
    public String label() {
        return "AI : Max";
    }

    @Override
    public Player build() {
        return new MaxAI();
    }
}
