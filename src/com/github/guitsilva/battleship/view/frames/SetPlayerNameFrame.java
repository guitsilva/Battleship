package com.github.guitsilva.battleship.view.frames;

import com.github.guitsilva.battleship.view.Console;

public class SetPlayerNameFrame implements Frame {

  public void render() {

    Console.clear();
    // IMPORTANT: 25 lines x 100 columns
    Console.print("Write player name and press enter.:", 100, true, ' ');
    Console.print("");
    Console.print("");
    Console.print("");
    Console.print("");
    Console.print("");
    Console.print("");
    Console.print("");
  }

}

