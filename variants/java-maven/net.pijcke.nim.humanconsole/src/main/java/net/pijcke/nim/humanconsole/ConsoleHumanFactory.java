package net.pijcke.nim.humanconsole;

import net.pijcke.nim.rules.Player;
import net.pijcke.nim.rules.PlayerFactory;

import java.util.Scanner;

public class ConsoleHumanFactory implements PlayerFactory {

    private static Scanner scanner = new Scanner(System.in);

    @Override
    public String label() {
        return "Human - Console";
    }

    @Override
    public Player build() {
        System.out.println("Please enter your name : ");
        String name = scanner.nextLine();
        return new ConsoleHuman(name);
    }
}
