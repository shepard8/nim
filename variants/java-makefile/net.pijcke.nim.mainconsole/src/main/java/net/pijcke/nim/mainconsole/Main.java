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

  public static void main(String[] args) throws IOException {

    factories.forEach(playerFactory ->
        System.out.printf("%d : %s%n", i++, playerFactory.label()));

    if (i == 0) {
      System.out.println("No player factory found. Can't start game.");
      System.exit(1);
    }

  }

}
