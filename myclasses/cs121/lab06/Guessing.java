import java.util.*;

/**
 * Demonstrates the use of a block statement in an if-else.
 *
 * @author Java Foundations
 * @author Ryan Thompson
 */
public class Guessing
{
	/**
	 * Plays a simple guessing game with the user.
	 * @param args
	 */
	public static void main(String[]args)
	{
		final int MAX = 10;
		int answer, guess;

		Scanner scan = new Scanner(System.in);
		Random generator = new Random();

		answer = generator.nextInt(MAX) + 1;

		System.out.print("I'm thinking of a number between 1 and "
				+MAX + ". Guess what it is: ");

		guess = scan.nextInt();
		
		while(guess != answer) 
		{
			if(guess <= 10 && guess > 0)
			{
				if(guess < answer)
				{
					System.out.println("Higher. Guess again");
					guess = scan.nextInt();
				}
				else
				{
					System.out.println("Lower. Guess again");
					guess = scan.nextInt();
				}
			}
			else
			{
				System.out.println("Your guess is out of range.");
				System.out.println("Enter a number between 1 and 10");
				guess = scan.nextInt();
			}
		}
		System.out.println("Winner Winner Chicken Dinner!");
		//System.out.println("Random answer = " + answer);
		scan.close();
	}
}