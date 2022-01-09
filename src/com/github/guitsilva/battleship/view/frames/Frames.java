package com.github.guitsilva.battleship.view.frames;

import com.github.guitsilva.battleship.view.Console;
import com.github.guitsilva.battleship.view.Prompt;
import com.github.guitsilva.battleship.model.player.Player;

public class Frames implements Frame {

  protected final Prompt prompt = new Prompt();
  private final TitleFrame titleFrame = new TitleFrame();
  private final GameOptionsFrame gameOptionsFrame = new GameOptionsFrame();
  private final GameModeFrame gameModeFrame = new GameModeFrame();
  private final SetPlayerNameFrame setPlayerNameFrame = new SetPlayerNameFrame();
  private Short process = 1;

  public void render() {
    Console.clear();
    // 12 lines, must be a total of 25
    Console.print("");
    Console.print("");
    Console.print("");
    Console.print("");
    Console.print("  ____        _   _   _           _     _      ", 100, true, ' ');
    Console.print("|  _ \\      | | | | | |         | |   (_)     ", 100, true, ' ');
    Console.print("| |_) | __ _| |_| |_| | ___  ___| |__  _ _ __ ", 100, true, ' ');
    Console.print("|  _ < / _` | __| __| |/ _ \\/ __| '_ \\| | '_ \\", 100, true, ' ');
    Console.print(" | |_) | (_| | |_| |_| |  __/\\__ \\ | | | | |_) |", 100, true, ' ');
    Console.print("|____/ \\__,_|\\__|\\__|_|\\___||___/_| |_|_| .__/", 100, true, ' ');
    Console.print("                                          | |   ", 100, true, ' ');
    Console.print("                                          |_|   ", 100, true, ' ');
    Console.print("");
    Console.print("");
    Console.print("");
    optionsRender(this.process);
  }

  public void optionsRender(Short frameNumber) {
    String option;

    switch (frameNumber) {

      case 1:
        titleFrame.render();
        titleFrameOptionsHandler();
        break;

      case 2:
        gameOptionsFrame.render();
        gameOptionsFrameHandler();
        break;

      case 3:
        setPlayerNameFrame.render();
        setPlayerNameFrameHandler();
        break;

      case 4:
        gameModeFrame.render();
        gameModeFrameHandler();
        break;

    }
  }

  private void titleFrameOptionsHandler() {
    String option;
    do {
      option = prompt.read();
      switch (option.toUpperCase()) {
        case "P":
          this.process = 2;
          optionsRender(this.process);
          break;
        case "Q":
          System.exit(0);

      }
    } while (option.toUpperCase() != "Q");
  }

  private void gameOptionsFrameHandler() {
    String option;
    do {
      option = prompt.read();
      switch (option.toUpperCase()) {
        case "N":
          this.process = 3;
          optionsRender(this.process);
          break;
        case "G":
          this.process = 4;
          optionsRender(this.process);
          break;
        case "P":
          this.process = 5;
          optionsRender(this.process);
          break;
        case "Q":
          System.exit(0);

      }
    } while (option.toUpperCase() != "Q");
  }

  // set player name in this block
  private void setPlayerNameFrameHandler() {
    String option;
    option = prompt.read();

    if (Player.isValidName(option)) {
      System.out.printf("%S", option);
      this.process = 2;
      optionsRender(this.process);

    }
    else setPlayerNameFrameHandler();
  }

  private void gameModeFrameHandler(){
    String option;
    option = prompt.read();

    do {
      switch (option.toUpperCase()){
        case "A":
          System.out.println("Automatic");
          this.process = 2;
          optionsRender(this.process);
          break;
        case "B":
          System.out.println("Manual");
          this.process = 2;
          optionsRender(this.process);
          break;
      }
    }while(option.toUpperCase() != "A" || option.toUpperCase() != "B");


  }
}


