/*
 * Author: Cole Polyak
 * 4 February 2019
 * Day6Pt1.java
 *
 * This class provides implementation for Day 6 Part 1 of Advent of Code 2015.
 */

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileInputStream;

class Day6Pt1 {
  // Our grid.
  public static boolean[][] grid = new boolean[1000][1000];

  public static void main(String[] args) {
    initializeGrid();

    Scanner input = null;

    // Scanner initialization.
    try {
      input = new Scanner(new FileInputStream("day6input.txt"));
    } catch(FileNotFoundException e) {
      System.err.println("File not found. Exiting.");
      System.exit(1);
    }

    // Processing input.
    while(input.hasNextLine()) {
      String curLine = input.nextLine();
      processCommand(curLine);

    }

    countOnLights();

  }

  // This method takes in a setting and two sets of coordinates denoting the corners of the square.
  private static void executeCommand(String setting, int[] firstCoords, int[] secondCoords) {
    // Inverts lights.
    if(setting.equals("toggle")) {
      for(int i = firstCoords[0]; i <= secondCoords[0]; i++) {
        for(int j = firstCoords[1]; j <= secondCoords[1]; j++) {
          grid[i][j] = !grid[i][j];
        }
      }
    }
    // Sets lights to specific setting.
    else if(setting.equals("true") || setting.equals("false")) {
      boolean readBoolean = Boolean.parseBoolean(setting);
      for(int i = firstCoords[0]; i <= secondCoords[0]; i++) {
        for(int j = firstCoords[1]; j <= secondCoords[1]; j++) {
          grid[i][j] = readBoolean;
        }
      }
    } else {
      System.err.println("Unfamiliar setting. Exiting.");
      System.exit(0);
    }
  }

  // This method takes in a raw line from input and translates it into our command format.
  private static void processCommand(String instruction) {
    // Splitting up each part of input.
    String[] commandParsed = instruction.split(" ");

    // Indicies of command portions change based on operatin.
    if(commandParsed[0].equals("turn")) {
      int[] firstCoords = parseCoordinates(commandParsed[2]);
      int[] secondCoords = parseCoordinates(commandParsed[4]);
      executeCommand(commandParsed[1], firstCoords, secondCoords);
    } else if(commandParsed[0].equals("toggle")){
      int[] firstCoords = parseCoordinates(commandParsed[1]);
      int[] secondCoords = parseCoordinates(commandParsed[3]);
      executeCommand(commandParsed[0], firstCoords, secondCoords);
    } else {
      System.err.println("Encountered unfamiliar command.");
      System.exit(0);
    }

  }

  // Parses the two integer values representing x and y from a string.
  private static int[] parseCoordinates(String input) {
    String[] inputSplit = input.split(",");
    int[] toReturn = new int[2];

    toReturn[0] = Integer.parseInt(inputSplit[0]);
    toReturn[1] = Integer.parseInt(inputSplit[1]);

    return toReturn;
  }

  // Walks grid and counts intensity.
  private static void countOnLights() {
    int count = 0;
    for(int i = 0; i < grid.length; i++){
      for(int j = 0; j < grid[0].length; j++) {
        if(grid[i][j]) count++;
      }
    }

    System.out.println("Total lights: " + count);
  }
}
