/*Pre lab question number 3
 * 
 * @author Ryan Thompson
 * 
 * asks the user for a number until the user enters a negative number 
 */
import java.util.Scanner;
public class prelab06_3 
{

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter a whole number between -999999 and 10: ");
		int userInput = scan.nextInt();
		
		while(userInput > -1) 
		{
			System.out.println("Wrong number." + "\n" + "Try again!");
			System.out.print("Enter a whole number between -999999 and 10: ");
			userInput = scan.nextInt();
			if(userInput < 1)
			{
				System.out.println("Winner Winner Chicken Dinner!");
			}
		}
		scan.close();
	}
}