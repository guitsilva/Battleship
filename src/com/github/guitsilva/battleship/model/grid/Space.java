package com.github.guitsilva.battleship.model.grid;

public enum Space {
  EMPTY,
  SHIP,
  HIT,
  MISS,
  HIT_D,
  MISS_D;

  public static boolean isValid(Space space) {
    if (space == null) {
      return false;
    }

    return true;
  }
}
