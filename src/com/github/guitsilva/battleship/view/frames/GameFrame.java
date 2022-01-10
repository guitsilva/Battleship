package com.github.guitsilva.battleship.view.frames;

import com.github.guitsilva.battleship.model.grid.Grid;
import com.github.guitsilva.battleship.view.Console;
import com.github.guitsilva.battleship.view.GridView;

public class GameFrame extends DistributionFrame {

  private Grid grid;

  public GameFrame(Grid grid) {
    super(grid);
    this.grid = grid;
  }

  @Override
  public void render() {
    Console.clear();

    this.renderHeader();
    GridView.render(grid);

    Console.print("");
    Console.print(String.format(
        "%s, choose the coordinates of your next shoot!",
        this.grid.getPlayer().getName()));
    Console.print("");
  }
}
