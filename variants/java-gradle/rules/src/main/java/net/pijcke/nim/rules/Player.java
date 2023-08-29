package net.pijcke.nim.rules;

public interface Player {

    String name();

    int play(final int sticks);

    default void message(String message) {
        // Override only if a human needs to read the messages.
    }
}
