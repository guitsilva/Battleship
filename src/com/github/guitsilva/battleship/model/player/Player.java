package com.github.guitsilva.battleship.model.player;

public class Player {
  final String name;

  public Player(String name) throws InvalidPlayerException {
    if (!isValidName(name)) {
      throw new InvalidPlayerException("invalid name");
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

  public static boolean isValid(Player player) {
    if (!isValidName(player.getName())) {
      return false;
    }

    return true;
  }
}
