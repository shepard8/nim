package net.pijcke.nim.aimax;

import net.pijcke.nim.rules.Nim;
import net.pijcke.nim.rules.Player;

public class MaxAI implements Player {

    @Override
    public String name() {
        return "MaxAI";
    }

    @Override
    public int play(int sticks) {
        return Math.min(Nim.MAX_STICKS_PER_TURN, sticks);
    }

}
