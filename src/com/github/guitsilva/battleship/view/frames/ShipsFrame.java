package com.github.guitsilva.battleship.view.frames;

import com.github.guitsilva.battleship.view.Console;

public class ShipsFrame extends Frame implements Renderable {

  public void render() {
    Console.clear();

    this.renderHeader();

    Console.print("Ships distribution on the grid:", 100, true, ' ');
    Console.print("");
    Console.print("(A) Auto", 100, true, ' ');
    Console.print("(M) Manual", 100, true, ' ');
    Console.print("");
    Console.print("");
    Console.print("");
    Console.print("");
    Console.print("");
  }

  public String promptOption() {
    String option;

    while (true) {
      option = prompt.read().toUpperCase();

      if (option.equals("A") || option.equals("M")) {
        break;
      } else {
        System.out.println("Invalid option. Try again!");
      }
    }

    return option;
  }
}
