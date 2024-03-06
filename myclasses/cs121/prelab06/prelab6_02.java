/* Pre lab question number 2
 * 
 *@author Ryan Thompson 
 * 
 * Reads user data until a certain value is value is entered
 */
import java.util.Random;
import java.util.Scanner;

public class prelab6_02
{
	public static void main(String[] args)
	{
		//setup - variables
		Random randomGenerator = new Random();
		Scanner scan = new Scanner(System.in);
		int sentinelValue = randomGenerator.nextInt(11);
		
		//scanning for user input
		System.out.print("Enter a whole number between 1 and 10: ");
		int userInput = scan.nextInt();
		if(userInput < 1 || userInput > 10)
		{
			System.out.println("You're number is invalid!");
		}
		
		//comparing user input to a random sentinel value
		while(userInput != sentinelValue)
		{
			System.out.println("Wrong number." + "\n" + "Try again!");
			System.out.print("Enter a whole number between 1 and 10: ");
			userInput = scan.nextInt();
			
			if(sentinelValue == userInput) 
			{
				System.out.println("Winner Winner Chicken Dinner!");
			}
		}		
		scan.close();
	}
}
