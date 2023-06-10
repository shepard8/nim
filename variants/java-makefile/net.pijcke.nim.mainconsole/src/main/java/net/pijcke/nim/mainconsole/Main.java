package net.pijcke.nim.mainconsole;

import net.pijcke.nim.rules.Nim;
import net.pijcke.nim.rules.Player;
import net.pijcke.nim.rules.PlayerFactory;

import java.io.IOException;
import java.util.*;

public class Main {

  private static final List<PlayerFactory> factories = new ArrayList<>();
  static {
    ServiceLoader.load(PlayerFactory.class).iterator().forEachRemaining(factories::add);
  }

  private static int i = 0;

  private static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {

    factories.forEach(playerFactory ->
        System.out.printf("%d : %s%n", i++, playerFactory.label()));

    if (i == 0) {
      System.out.println("No player factory found. Can't start game.");
      System.exit(1);
    }

    Player player1 = buildPlayer(1);
    Player player2 = buildPlayer(2);

    new Nim(player1, player2, 42).start();

  }

  private static Player buildPlayer(final int number) throws IOException {
    System.out.printf("Enter player %d type : ", number);
    int index = scanner.nextInt();
    if (index < 0 || index >= i) {
      throw new InputMismatchException("Not in range");
    }
    return factories.get(index).build();
  }

}
