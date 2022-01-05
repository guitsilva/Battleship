package com.github.guitsilva.battleship.view;

import java.util.Scanner;

public class Prompt {

  private final Scanner scanner;

  public Prompt() {
    this.scanner = new Scanner(System.in);
  }

  public String read() {
    String input;

    while (true) {
      this.render();
      input = this.scanner.nextLine();

      if (this.isValidInput(input)) {
        break;
      }
    }

    return input;
  }

  private boolean isValidInput(String input) {

    if (input == null || input.isBlank()) {
      return false;
    }

    return true;
  }

  private void render() {
    System.out.print("#: ");
  }
}
