import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**Random Walk Test
 * 
 * @author Ryan Thompson
 * 
 * Calls the methods from RandomWalk.java to create a random walk
 */

public class RandomWalkTest
{
	private static int gridSize;
	private static long seed;
	/**
	 * Gets input from the user, that will be used as the grid size and a random seed 
	 */
	private static void getInput()
	{
		Scanner scan = new Scanner(System.in);
		
		//Checking if gridSize is greater than 0.
		System.out.print("Enter the grid size: ");
		gridSize = scan.nextInt();
		while(gridSize <= 0)
		{
			System.out.print("Error: grid size must be positive.\n");
			System.out.print("Enter the grid size: ");
			gridSize = scan.nextInt();
		}
		
		//Checking if seed is greater than or equal to 0.
		System.out.print("Enter a random seed value (0 for no seed): ");
		seed = scan.nextLong();
		while(seed < 0)
		{
			System.out.print("Error: random seed must be >= 0.\n");
			System.out.print("Enter a random seed value (0 for no seed): ");
			seed = scan.nextLong();
		}
		scan.close();
	}

	/**
	 * @param args
	 * Calls getInput() to use user data and calls methods from RandomWalk.java to create a random walk.
	 */
	public static void main(String[] args)
	{	
		getInput();	
		RandomWalk walker;
		boolean tf = false;
		
		if(seed == 0)
		{
			walker = new RandomWalk(gridSize);	
			while(tf == false)
			{
				walker.createWalk();
				tf = walker.isDone();
			}
		}
		else
		{
			walker = new RandomWalk(gridSize, seed);	
			while(tf == false)
			{
				walker.createWalk();
				tf = walker.isDone();
			}
		}
		walker.toString();
	}
}
