package net.pijcke.nim.aione;

import net.pijcke.nim.rules.Player;
import net.pijcke.nim.rules.PlayerFactory;

public class OneAIFactory implements PlayerFactory {

    @Override
    public String label() {
        return "AI : One";
    }

    @Override
    public Player build() {
        return new OneAI();
    }
}
