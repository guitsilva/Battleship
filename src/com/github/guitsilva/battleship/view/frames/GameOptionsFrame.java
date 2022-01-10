package com.github.guitsilva.battleship.view.frames;

import com.github.guitsilva.battleship.view.Console;


public class GameOptionsFrame implements Frame {

  public void render() {
    Console.clear();
    // IMPORTANT: 25 lines x 100 columns
    Console.print("Options:", 100, true, ' ');
    Console.print("");
    Console.print("(N) Set player name", 100, true, ' ');
    Console.print("(G) Set game mode", 100, true, ' ');
    Console.print("(P) Play", 100, true, ' ');
    Console.print("(Q) Quit", 100, true, ' ');
    Console.print("");
    Console.print("");
    Console.print("");
  }
}
