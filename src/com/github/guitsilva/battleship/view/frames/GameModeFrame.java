package com.github.guitsilva.battleship.view.frames;

import com.github.guitsilva.battleship.view.Console;

public class GameModeFrame implements Frame{

  public void render(){
    Console.clear();
    // IMPORTANT: 25 lines x 100 columns
    Console.print("How did you want to allocate your ships on the board?", 100, true, ' ');
    Console.print("");
    Console.print("(A) Automatic", 100, true, ' ');
    Console.print("(M) Manual", 100, true, ' ');
    Console.print("");
    Console.print("");
    Console.print("");
  }


}
