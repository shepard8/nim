package net.pijcke.nim.humanconsole;

import net.pijcke.nim.rules.Player;

import java.util.Scanner;

public class ConsoleHuman implements Player {

    private static final Scanner scanner = new Scanner(System.in);

    private final String name;

    public ConsoleHuman(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public int play(int sticks) {
        System.out.printf("%s, how many sticks do you want to remove (%d remaining)? ", name, sticks);
        return scanner.nextInt();
    }

    @Override
    public void message(String message) {
        System.out.printf("Message for %s: %s%n", name, message);
    }

}
