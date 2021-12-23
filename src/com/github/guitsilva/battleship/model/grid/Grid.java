package com.github.guitsilva.battleship.model.grid;

public class Grid {
  public static final byte SIZE = 10;

  private final Space[][] spaces;

  public Grid() {
    this.spaces = new Space[Grid.SIZE][Grid.SIZE];
    this.fillAllSpacesWith(Space.EMPTY);
  }

  public Space[][] getSpaces() {
    return this.spaces;
  }

  public Space getSpace(byte line, byte column) {
    if (!isValidCoordinate(line) || !isValidCoordinate(column)) {
      return null;
    }

    return this.spaces[line][column];
  }

  public void setSpace(byte line, byte column, Space newSpace)
      throws InvalidCoordinateException, InvalidSpaceException {

    if (!isValidCoordinate(line)) {
      throw new InvalidCoordinateException("invalid 'x' coordinate");
    }

    if (!isValidCoordinate(column)) {
      throw new InvalidCoordinateException("invalid 'y' coordinate");
    }

    if (!isValidSpace(newSpace)) {
      throw new InvalidSpaceException("invalid space type");
    }

    this.spaces[line][column] = newSpace;
  }

  public byte getNumberOfShips() {
    byte numberOfShips = 0;

    for (byte line = 0; line < Grid.SIZE; line++) {
      for (byte column = 0; column < Grid.SIZE; column++) {
        if (this.getSpace(line, column) == Space.SHIP) {
          numberOfShips++;
        }
      }
    }

    return numberOfShips;
  }

  public static boolean isValidCoordinate(byte coordinate) {
    if (0 <= coordinate && coordinate < Grid.SIZE) {
      return true;
    }

    return false;
  }

  public static boolean isValidSpace(Space space) {
    if (space != null) {
      return true;
    }

    return false;
  }

  private void fillAllSpacesWith(Space space) {
    for (byte line = 0; line < Grid.SIZE; line++) {
      for (byte column = 0; column < Grid.SIZE; column++) {
        this.spaces[line][column] = space;
      }
    }
  }
}
