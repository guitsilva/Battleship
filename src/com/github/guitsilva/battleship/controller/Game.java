package com.github.guitsilva.battleship.controller;

import com.github.guitsilva.battleship.model.coordinates.Coordinates;
import com.github.guitsilva.battleship.model.grid.Grid;
import com.github.guitsilva.battleship.model.grid.Space;
import com.github.guitsilva.battleship.model.player.Player;
import com.github.guitsilva.battleship.view.Console;
import com.github.guitsilva.battleship.view.frames.InitialFrame;
import com.github.guitsilva.battleship.view.frames.PlayerFrame;
import com.github.guitsilva.battleship.view.frames.ResultFrame;
import com.github.guitsilva.battleship.view.frames.ShipsFrame;
import com.github.guitsilva.battleship.view.frames.DistributionFrame;
import com.github.guitsilva.battleship.view.frames.GameFrame;

public class Game {

  public static final byte MAX_NUMBER_OF_SHIPS = 10;

  private Grid playerGrid;
  private Grid computerGrid;

  public void load() {
    InitialFrame initialFrame = new InitialFrame();
    initialFrame.render();

    if (initialFrame.promptOption().equals("Q")) {
      System.exit(0);
    }

    PlayerFrame playerFrame = new PlayerFrame();
    playerFrame.render();

    Player humanPlayer = playerFrame.promptPlayer();
    this.playerGrid = new Grid(humanPlayer);

    Player computerPlayer = new Player("Computer");
    this.computerGrid = new Grid(computerPlayer);
    this.distributeShipsAutomatically(computerGrid);

    ShipsFrame shipsFrame = new ShipsFrame();
    shipsFrame.render();

    String shipsDistribution = shipsFrame.promptOption();

    if (shipsDistribution.equals("A")) {
      this.distributeShipsAutomatically(playerGrid);
    } else {
      this.distributeShipsManually(playerGrid);
    }

    this.play();
  }

  private void distributeShipsAutomatically(Grid grid) {

    for (int ship = 0; ship < MAX_NUMBER_OF_SHIPS; ship++) {

      while (true) {

        Coordinates randomCoordinates = Coordinates.getRandomCoordinates();

        if (grid.getSpace(randomCoordinates) == Space.EMPTY) {
          grid.setSpace(randomCoordinates, Space.SHIP);
          break;
        }
      }
    }
  }

  private void distributeShipsManually(Grid grid) {

    DistributionFrame distributionFrame = new DistributionFrame(grid);

    for (int ship = 0; ship < MAX_NUMBER_OF_SHIPS; ship++) {

      while (true) {
        Console.clear();

        distributionFrame.render();

        System.out.printf("Ship %d of %d%n", ship + 1, MAX_NUMBER_OF_SHIPS);
        Coordinates coordinates = distributionFrame.promptCoordinates();

        if (grid.getSpace(coordinates) == Space.EMPTY) {
          grid.setSpace(coordinates, Space.SHIP);
          break;
        }
      }
    }
  }

  private void play() {

    GameFrame gameFrame = new GameFrame(playerGrid);

    while (true) {
      gameFrame.render();

      // Console.clear();
      // GridView.render(playerGrid);
      // GridView.render(computerGrid);

      this.shoot(
          gameFrame.promptCoordinates(),
          this.playerGrid,
          this.computerGrid);

      if (this.computerGrid.getNumberOfShips() == 0) {
        ResultFrame resultFrame = new ResultFrame(playerGrid, computerGrid);
        resultFrame.render();
        break;
      }

      this.getComputerShoot();
      if (this.playerGrid.getNumberOfShips() == 0) {
        ResultFrame resultFrame = new ResultFrame(computerGrid, playerGrid);
        resultFrame.render();
        break;
      }
    }
  }

  private void getComputerShoot() {
    Coordinates randomCoordinates;

    while (true) {
      randomCoordinates = Coordinates.getRandomCoordinates();

      Space shootSpace = this.computerGrid.getSpace(randomCoordinates);

      if (shootSpace == Space.EMPTY || shootSpace == Space.SHIP) {
        break;
      }
    }

    this.shoot(
        randomCoordinates,
        this.computerGrid,
        this.playerGrid);
  }

  private void shoot(Coordinates coordinates, Grid originGrid, Grid targetGrid) {

    Space originSpace = originGrid.getSpace(coordinates);
    Space targetSpace = targetGrid.getSpace(coordinates);

    boolean hit = false;

    if (targetSpace == Space.SHIP) {
      hit = true;
      targetGrid.setSpace(coordinates, Space.EMPTY);
    }

    if (targetSpace == Space.HIT_D) {
      hit = true;
      targetGrid.setSpace(coordinates, Space.HIT);
    }

    if (targetSpace == Space.MISS_D) {
      hit = true;
      targetGrid.setSpace(coordinates, Space.MISS);
    }

    if (hit) {
      if (originSpace == Space.EMPTY) {
        originGrid.setSpace(coordinates, Space.HIT);
      }

      if (originSpace == Space.SHIP) {
        originGrid.setSpace(coordinates, Space.HIT_D);
      }
    } else {
      if (originSpace == Space.EMPTY) {
        originGrid.setSpace(coordinates, Space.MISS);
      }

      if (originSpace == Space.SHIP) {
        originGrid.setSpace(coordinates, Space.MISS_D);
      }
    }
  }
}
