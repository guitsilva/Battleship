package com.github.guitsilva.battleship.view.frames;

import com.github.guitsilva.battleship.model.grid.Grid;
import com.github.guitsilva.battleship.view.Console;
import com.github.guitsilva.battleship.view.GridView;

public class ResultFrame extends Frame implements Renderable {

  private final Grid winnerGrid;
  private final Grid looserGrid;

  public ResultFrame(Grid winnerGrid, Grid looserGrid) {
    this.winnerGrid = winnerGrid;
    this.looserGrid = looserGrid;
  }

  public void render() {
    Console.clear();

    Console.print("");
    Console.print("");
    Console.print("");
    Console.print("WINNER!", 100, true);
    GridView.render(winnerGrid);

    Console.print("");
    Console.print("");
    Console.print("");
    Console.print("LOOSER!", 100, true);
    GridView.render(looserGrid);
  }
}
