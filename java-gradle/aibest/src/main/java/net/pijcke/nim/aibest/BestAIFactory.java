package net.pijcke.nim.aibest;

import net.pijcke.nim.rules.Player;
import net.pijcke.nim.rules.PlayerFactory;

public class BestAIFactory implements PlayerFactory {

    @Override
    public String label() {
        return "AI : Best";
    }

    @Override
    public Player build() {
        return new BestAI();
    }

}
