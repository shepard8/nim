package net.pijcke.nim.rules;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class Nim {

  public static final int MAX_STICKS_PER_TURN = 3;


  private final List<Player> players;
  private int sticks;

  public Nim(final List<Player> players, final int sticks) {
    this.players = players;
    this.sticks = sticks;
  }

}
