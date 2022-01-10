package com.github.guitsilva.battleship.view;

import com.github.guitsilva.battleship.model.coordinates.Coordinates;
import com.github.guitsilva.battleship.model.grid.Grid;
import com.github.guitsilva.battleship.model.grid.Space;

public class GridView {

  public static void render(Grid grid) {

    Console.print("---------------------------------------------", 100, true);
    Console.print(grid.getPlayer().getName(), 100, true);
    Console.print("---------------------------------------------", 100, true);

    StringBuilder columnsHeader = new StringBuilder("|   |");
    for (byte column = 0; column < Grid.SIZE; column++) {
      columnsHeader.append(String.format(" %d |", column));
    }

    Console.print(columnsHeader.toString(), 100, true);
    Console.print("---------------------------------------------", 100, true);

    for (byte line = 0; line < Coordinates.CHARS.length(); line++) {

      char lineChar = Coordinates.CHARS.charAt(line);

      StringBuilder lineString = new StringBuilder(String.format("| %c |", lineChar));
      for (byte column = 0; column < Grid.SIZE; column++) {
        Space space = grid.getSpace(new Coordinates(line, column));
        char spaceChar = ' ';

        switch (space) {

          case EMPTY:
            spaceChar = ' ';
            break;

          case SHIP:
            spaceChar = 'N';
            break;

          case HIT:
            spaceChar = '*';
            break;

          case MISS:
            spaceChar = '-';
            break;

          case HIT_D:
            spaceChar = 'X';
            break;

          case MISS_D:
            spaceChar = 'n';
            break;
        }

        lineString.append(String.format(" %c |", spaceChar));
      }

      Console.print(lineString.toString(), 100, true);
      Console.print("---------------------------------------------", 100, true);
    }

    Console.print("");
  }
}
