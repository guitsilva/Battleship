package com.github.guitsilva.battleship.model.coordinates;

import java.util.Random;

import com.github.guitsilva.battleship.model.grid.Grid;

public class Coordinates {

  public final static String CHARS = "ABCDEFGHIJ";

  private final byte line;
  private final byte column;

  public Coordinates(char lineChar, byte column) {
    this(convertCharToIndex(lineChar), column);
  }

  public Coordinates(byte line, byte column)
      throws InvalidCoordinateException {

    if (!isValidCoordinate(line)) {
      throw new InvalidCoordinateException("invalid line coordinate");
    }

    if (!isValidCoordinate(column)) {
      throw new InvalidCoordinateException("invalid column coordinate");
    }

    this.line = line;
    this.column = column;
  }

  public byte getLine() {
    return this.line;
  }

  public char getLineChar() {
    return convertIndexToChar(this.line);
  }

  public byte getColumn() {
    return this.column;
  }

  public char getColumnChar() {
    return convertIndexToChar(this.column);
  }

  public static char convertIndexToChar(byte coordinateIndex) {
    return CHARS.charAt(coordinateIndex);
  }

  public static byte convertCharToIndex(char coordinateChar) {
    return (byte) CHARS.indexOf(coordinateChar);
  }

  public static boolean isValidCoordinateChar(char coordinateChar) {
    byte coordinate = convertCharToIndex(coordinateChar);

    return isValidCoordinate(coordinate);
  }

  public static boolean isValidCoordinate(byte coordinate) {
    if (coordinate < 0 || coordinate >= Grid.SIZE) {
      return false;
    }

    return true;
  }

  public static boolean isValid(Coordinates coordinates) {
    byte line = coordinates.getLine();
    byte column = coordinates.getColumn();

    if (!isValidCoordinate(line) || !isValidCoordinate(column)) {
      return false;
    }

    return true;
  }

  public static Coordinates getRandomCoordinates() {

    byte randomLine = (byte) new Random().nextInt(CHARS.length());
    byte randomColumn = (byte) new Random().nextInt(CHARS.length());

    return new Coordinates(randomLine, randomColumn);
  }
}
