package aoc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Author: Cole Polyak
 * 25 February 2018
 * Advent of Code 2015 Day 3
 * 
 */

// TODO Determine more elegant solution to array of houses creation.
// TODO Implement safe file initialization
// TODO Part 2.

public class Day3Pt1 {

	public static void main(String[] args) {
		
		Scanner file = null;
		
		try
		{
			file = new Scanner(new FileInputStream("Day3Input.txt"));
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
			System.exit(1);
		}
		
		int[][] arr = new int[10000][10000];
		
		int x = 4999;
		int y = 4999;
		
		int count = 0;
		
		String input = file.next();
		System.out.println(input);
		int currentIndex = 0;
		
		for(int i = 0; i < input.length(); ++i)
		{
			String cur = input.substring(currentIndex, currentIndex+1);
			
			if("<".equals(cur))
			{
				System.out.println("<");
				++arr[x][y];
				++arr[x-1][y];
				--x;
			}
			
			else if(">".equals(cur))
			{
				System.out.println(">");
				++arr[x][y];
				++arr[x+1][y];
				++x;
			}
			else if("V".equals(cur))
			{
				System.out.println("V");
				++arr[x][y];
				++arr[x][y-1];
				--y;
			}
			else if("^".equals(cur))
			{
				System.out.println("^");
				++arr[x][y];
				++arr[x][y+1];
				++y;
			}
			
			++count;
			++currentIndex;
		}
		
		int housesReceivingAtLeastOne = 0;
		
		for(int i = 0; i < arr.length; ++i)
		{
			for(int j = 0; j < arr[i].length; ++j)
			{
				if(arr[i][j] >= 1)
				{
					++housesReceivingAtLeastOne; 
				}
			}
		}
		
		System.out.println("Total iterative count: " + count);
		System.out.println("Houses receiving atleast one gift: " + housesReceivingAtLeastOne);
		
		

	}

}
