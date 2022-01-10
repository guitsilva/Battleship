package com.github.guitsilva.battleship.view.frames;

import com.github.guitsilva.battleship.model.player.Player;
import com.github.guitsilva.battleship.view.Console;

public class PlayerFrame extends Frame implements Renderable {

  public void render() {

    Console.clear();

    this.renderHeader();

    Console.print("Player name:", 100, true, ' ');
    Console.print("");
    Console.print("");
    Console.print("");
    Console.print("");
    Console.print("");
    Console.print("");
    Console.print("");
    Console.print("");
  }

  public Player promptPlayer() {

    String name;

    while (true) {
      name = prompt.read();

      if (Player.isValidName(name)) {
        break;
      } else {
        Console.print("Invalid name. Try again!");
      }
    }

    return new Player(name);
  }
}
