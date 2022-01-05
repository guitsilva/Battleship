package com.github.guitsilva.battleship.view.frames;

import com.github.guitsilva.battleship.view.Console;
import com.github.guitsilva.battleship.view.Prompt;

public class TitleFrame implements Frame {

  private final Prompt prompt;

  public TitleFrame() {
    this.prompt = new Prompt();
  }

  public void render() {
    Console.clear();

    // IMPORTANT: 25 lines x 100 columns
    Console.print("");
    Console.print("");
    Console.print("");
    Console.print("");
    Console.print("  ____        _   _   _           _     _      ", 100, true, ' ');
    Console.print("|  _ \\      | | | | | |         | |   (_)     ", 100, true, ' ');
    Console.print("| |_) | __ _| |_| |_| | ___  ___| |__  _ _ __ ", 100, true, ' ');
    Console.print("|  _ < / _` | __| __| |/ _ \\/ __| '_ \\| | '_ \\", 100, true, ' ');
    Console.print(" | |_) | (_| | |_| |_| |  __/\\__ \\ | | | | |_) |", 100, true, ' ');
    Console.print("|____/ \\__,_|\\__|\\__|_|\\___||___/_| |_|_| .__/", 100, true, ' ');
    Console.print("                                          | |   ", 100, true, ' ');
    Console.print("                                          |_|   ", 100, true, ' ');
    Console.print("");
    Console.print("");
    Console.print("");
    Console.print("");
    Console.print("Options:", 100, true, ' ');
    Console.print("");
    Console.print("(P) Play", 100, true, ' ');
    Console.print("(Q) Quit", 100, true, ' ');
    Console.print("");
    Console.print("");
    Console.print("");
    Console.print("");
    Console.print("");

    this.readOption();
  }

  public void readOption() {
    String option = "";

    do {
      option = this.prompt.read();

      switch (option.toUpperCase()) {

        case "P":
          System.out.println("Play");
          continue;

        case "Q":
          System.out.println("Quit");
          continue;

        default:
          System.out.println("Invalid option. Try again!");
      }

    } while (!option.equalsIgnoreCase("Q"));
  }
}
