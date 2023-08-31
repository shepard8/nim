package net.pijcke.nim.airandom;

import net.pijcke.nim.rules.Nim;
import net.pijcke.nim.rules.Player;

import java.util.Random;

public class RandomAI implements Player {

    private final Random random;

    public RandomAI() {
        this.random = new Random();
    }

    @Override
    public String name() {
        return "Random AI";
    }

    @Override
    public int play(int sticks) {
        return random.nextInt(Math.min(sticks, Nim.MAX_STICKS_PER_TURN));
    }

}
