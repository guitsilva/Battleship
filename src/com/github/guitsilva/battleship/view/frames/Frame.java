package com.github.guitsilva.battleship.view.frames;

import com.github.guitsilva.battleship.view.Console;
import com.github.guitsilva.battleship.view.Prompt;

public class Frame {

  protected final Prompt prompt;

  public Frame() {
    this.prompt = new Prompt();
  }

  protected void renderHeader() {
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
  }
}
