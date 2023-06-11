package net.pijcke.nim.rules;

public class Nim {

    public static final int MAX_STICKS_PER_TURN = 3;

    private Player currentPlayer, otherPlayer;

    private int sticks;

    public Nim(final Player player1, final Player player2, final int sticks) {
        this.currentPlayer = player1;
        this.otherPlayer = player2;
        this.sticks = sticks;
    }

    public void start() {
        while (true) {
            final int sticksToRemove = currentPlayer.play(sticks);

            if (sticksToRemove < 1 || sticksToRemove > MAX_STICKS_PER_TURN || sticksToRemove > sticks) {
                broadcast(String.format("Player %s has been eliminated for not following the rules.", currentPlayer));
                break;
            }

            if (sticksToRemove == sticks) {
                broadcast(String.format("Player %s has been eliminated for removing the last stick.", currentPlayer));
                break;
            }

            sticks -= sticksToRemove;
            if (sticks > 1) {
                broadcast(String.format("%s removed %d sticks. There are %d sticks remaining.", currentPlayer, sticksToRemove, sticks));
            }
            else {
                broadcast(String.format("%s removed %d sticks. There is 1 stick remaining.", currentPlayer, sticksToRemove));
            }

            swapPlayers();
        }
    }

    private void broadcast(String message) {
        currentPlayer.message(message);
        otherPlayer.message(message);
    }

    private void swapPlayers() {
        Player temp = currentPlayer;
        currentPlayer = otherPlayer;
        otherPlayer = temp;
    }

}
