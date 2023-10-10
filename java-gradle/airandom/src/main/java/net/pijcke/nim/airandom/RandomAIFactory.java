package net.pijcke.nim.airandom;

import net.pijcke.nim.rules.Player;
import net.pijcke.nim.rules.PlayerFactory;

public class RandomAIFactory implements PlayerFactory {

    @Override
    public String label() {
        return "AI : Random";
    }

    @Override
    public Player build() {
        return new RandomAI();
    }

}
