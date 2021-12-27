package com.github.guitsilva.battleship.model.grid;

import com.github.guitsilva.battleship.model.coordinates.Coordinates;
import com.github.guitsilva.battleship.model.coordinates.InvalidCoordinateException;

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

  public Space getSpace(Coordinates coordinates) {
    if (!Coordinates.isValid(coordinates)) {
      return null;
    }

    return this.spaces[coordinates.getLine()][coordinates.getColumn()];
  }

  public void setSpace(Coordinates coordinates, Space space)
      throws InvalidSpaceException {

    if (!Coordinates.isValid(coordinates)) {
      throw new InvalidCoordinateException("invalid coordinates");
    }

    if (!Space.isValid(space)) {
      throw new InvalidSpaceException("invalid space Type");
    }

    this.spaces[coordinates.getLine()][coordinates.getColumn()] = space;
  }

  public byte getNumberOfShips() {
    byte numberOfShips = 0;

    for (byte line = 0; line < Grid.SIZE; line++) {
      for (byte column = 0; column < Grid.SIZE; column++) {
        if (this.getSpace(new Coordinates(line, column)) == Space.SHIP) {
          numberOfShips++;
        }
      }
    }

    return numberOfShips;
  }

  private void fillAllSpacesWith(Space space) {
    for (byte line = 0; line < Grid.SIZE; line++) {
      for (byte column = 0; column < Grid.SIZE; column++) {
        this.setSpace(new Coordinates(line, column), space);
      }
    }
  }
}
