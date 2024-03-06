/**
 * CS 121 Lab: Conditionals and Loops 2
 * @author CS121 Instructors
 * @author Ryan Thompson
 */
public class GoingLoopy
{
	public static void main(String[] args)
	{
		/*
		 * TODO: Print multiples of 7 between 0 and 100 using a while loop
		 *
		 * 1. Use a while loop to evaluate every integer from 0 to 100
		 *    to see which are evenly divisible by 7.
		 * 2. Print each multiple of 7 and keep track of the number of
		 *    multiples of 7 as you go. (Use the numMultiples variable initialized
		 *    below to keep track of the number of multiples.)
		 */
		System.out.println("Multiples of 7 between 0 and 100 (using while loop):");

		int numMultiples = 0; // Keeps track of the number of integers evenly divisible by 7.

		/*------------------ Your code goes here ------------------*/

		int count = 0;
		while(count <= 100) 
		{
			System.out.print(count + " ");
			numMultiples++;
			count+=7;
		}
		System.out.print("\n");
		/*---------------------------------------------------------*/

		// Prints the total number of multiples of 7.
		System.out.println("total: " + numMultiples);
		System.out.println();

		/*
		 * TODO: Print multiples of 7 between 0 and 100 using a for loop
		 *
		 * 1. Use a for loop to accomplish exactly the same task as in the previous
		 *    while loop.
		 */
		System.out.println("Multiples of 7 between 0 and 100 (using for loop):");

		numMultiples = 0; // Keeps track of the number of integers evenly divisible by 7.

		/*------------------ Your code goes here ------------------*/
		
		for(count = 0; count <= 100; count+=7) 
		{
				System.out.print(count + " ");
				numMultiples++;
		}
		System.out.print("\n");

		/*---------------------------------------------------------*/

		// Prints the total number of multiples of 7.
		System.out.println("total: " + numMultiples);
		System.out.println();

		/*
		 * TODO: Print a 2-dimensional table of values using a nested for loop
		 *
		 * 1. The outer loop will iterate from 1 to MAX_ROWS rows.
		 * 2. The inner loop will iterate from 1 to MAX_COLS columns.
		 * 3. Print each value in the table as the product of the row and column numbers.
		 *    (rowNumber x columnNumber).
		 */

		final int MAX_ROWS = 5;
		final int MAX_COLS = 10;

		System.out.println("Multiplication table:");
		/*------------------ Your code goes here ------------------*/
		for(int rowNumber = 1; rowNumber <= MAX_ROWS; rowNumber++)
		{
			for(int columnNumber = 1; columnNumber <= MAX_COLS; columnNumber++)
			{
				System.out.print(columnNumber*rowNumber + " \t ");
			}
			System.out.println(" ");
		}
		
		/*---------------------------------------------------------*/
	}
}