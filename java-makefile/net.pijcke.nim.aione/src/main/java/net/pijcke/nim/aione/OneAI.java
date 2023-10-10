package net.pijcke.nim.aione;

import net.pijcke.nim.rules.Player;

public class OneAI implements Player {

  @Override
  public String name() {
    return "One AI";
  }

  @Override
  public int play(final int sticks) {
    return 1;
  }

  @Override
  public void message(String message) {
    System.out.println(this.toString() + " : " + message);
  }

}

