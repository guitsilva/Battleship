package com.github.guitsilva.battleship.view.frames;

import com.github.guitsilva.battleship.view.Console;

public class InitialFrame extends Frame implements Renderable {

  public void render() {
    Console.clear();

    this.renderHeader();

    Console.print("Options:", 100, true, ' ');
    Console.print("");
    Console.print("(P) Play", 100, true, ' ');
    Console.print("(Q) Quit", 100, true, ' ');
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

      if (option.equals("P") || option.equals("Q")) {
        break;
      } else {
        System.out.println("Invalid option. Try again!");
      }
    }

    return option;
  }
}
