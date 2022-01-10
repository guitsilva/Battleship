package com.github.guitsilva.battleship.view.frames;

import com.github.guitsilva.battleship.model.coordinates.Coordinates;
import com.github.guitsilva.battleship.model.grid.Grid;
import com.github.guitsilva.battleship.view.Console;
import com.github.guitsilva.battleship.view.GridView;

public class DistributionFrame extends Frame implements Renderable {

  private Grid grid;

  public DistributionFrame(Grid grid) {
    this.grid = grid;
  }

  public void render() {
    Console.clear();

    this.renderHeader();
    GridView.render(grid);

    Console.print("");
    Console.print(String.format(
        "%s, choose the position of your ships on the grid!",
        this.grid.getPlayer().getName()));
    Console.print("");
  }

  public Coordinates promptCoordinates() {

    char lineChar;
    byte column;

    while (true) {
      String coordinatesString = this.prompt.read().toUpperCase();

      if (coordinatesString.isBlank() || coordinatesString.length() < 2) {
        System.out.println("Invalid coordinates. Try again!");
        continue;
      }

      lineChar = coordinatesString.charAt(0);

      if (!Coordinates.isValidCoordinateChar(lineChar)) {
        System.out.println("Invalid line. Try again!");
        continue;
      }

      try {
        column = Byte.parseByte(coordinatesString.substring(1));
      } catch (NumberFormatException e) {
        System.out.println("Invalid column. Try again!");
        continue;
      }

      if (!Coordinates.isValidCoordinate(column)) {
        System.out.println("Invalid column. Try again!");
        continue;
      }

      break;
    }

    return new Coordinates(lineChar, column);
  }
}
