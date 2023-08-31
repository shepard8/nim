package net.pijcke.nim.aibest;

import net.pijcke.nim.rules.Nim;
import net.pijcke.nim.rules.Player;

import java.util.Random;

public class BestAI implements Player {

    private final Random random;
    private static final int MAX_PLUS_ONE = Nim.MAX_STICKS_PER_TURN + 1;
    private static final int MAX = Nim.MAX_STICKS_PER_TURN;

    public BestAI() {
        random = new Random();

    }

    @Override
    public String name() {
        return "Best AI";
    }

    @Override
    public int play(int sticks) {
        if (sticks == 1) {
            return 1;
        }

        if (sticks % (MAX_PLUS_ONE) == 1) {
            return random.nextInt(MAX) + 1;
        }

        return ((sticks % MAX_PLUS_ONE) + MAX) % MAX_PLUS_ONE;
    }

}
