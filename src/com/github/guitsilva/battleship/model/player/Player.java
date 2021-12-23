package com.github.guitsilva.battleship.model.player;

public class Player {
  final String name;

  public Player(String name) {
    if (!isValidName(name)) {
      throw new InvalidNameException("invalid name");
    }

    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public static boolean isValidName(String name) {
    if (name == null) {
      return false;
    }

    if (name.isBlank()) {
      return false;
    }

    return true;
  }
}
