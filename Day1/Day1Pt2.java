package aoc;

// Import block
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

// TODO ADD DATE

/*
 * Author: Cole Polyak
 * Advent of Code 2015 Day 1 Part 2
 * February 2018
 *
 */

/*
 * For this challenge my program had to read in a text file filled with open and closed parenthesis.
 * The open parens would make our character ascend one floor and the close parens would cause our 
 * character to descend one floor. We had to parse through the file and output the character that causes
 * the character to descend into a negative floor. 
 */
public class Day1Pt2 {

	public static Scanner file = null;

	public static void main(String[] args) {

		// Safe file input stream initialization.
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please input file name: ");
		
		initFile(keyboard.next());
		
		// The entire file can be read into one string since the file is one line.
		System.out.println("File success. Reading file...");
		String input = file.next();
		
		// Closing our scanners.
		keyboard.close();
		file.close();
	
		int currentFloor = 0;
		int curIndex = 0;
		
		
		// Loops until the current floor is negative.
		while(currentFloor != -1)
		{
			try
			{
				// Up a floor.
				if("(".equals(input.substring(curIndex, curIndex+1)))
				{
					System.out.println("Plus 1");
					++currentFloor;
				}
				
				// Down a floor.
				else if(")".equals(input.substring(curIndex, curIndex+1)))
				{
					System.out.println("Minus 1");
					--currentFloor;
				}
				
				++curIndex;
						
			}
			// Catches the end of the file and breaks the infinite loop.
			catch(StringIndexOutOfBoundsException e)
			{
				break;
			}
		}
		
		
		// And output.
		System.out.println("--------------------------");
		System.out.println("The index that causes a negative floor is: " + curIndex );
		System.out.println("Current Floor: " + currentFloor);
		System.out.println("--------------------------");
		
		

	}

	// Safe fileinputstream creation.
	public static String initFile(String fileName)
	{
		Scanner keyboard = new Scanner(System.in);

		// Tries to create input stream.
		try
		{
			file = new Scanner(new FileInputStream(fileName));
		}
		catch(FileNotFoundException e)
		{
			// Infinite until valid file is inputted.
			System.out.println("File not found. Please double check filename and try again.");
			initFile(keyboard.next());
		}

		keyboard.close();
		return fileName;
	}
}
