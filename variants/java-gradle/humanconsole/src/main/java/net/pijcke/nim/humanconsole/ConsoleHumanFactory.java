package net.pijcke.nim.humanconsole;

import net.pijcke.nim.rules.Player;
import net.pijcke.nim.rules.PlayerFactory;

public class ConsoleHumanFactory implements PlayerFactory {

    @Override
    public String label() {
        return "Human : Console";
    }

    @Override
    public Player build() {
        String name = "Fabian";
        return new ConsoleHuman(name);
    }

}
