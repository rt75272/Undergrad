/**Dice Roller
 * 
 * @author Ryan Thompson
 *
 * Rolls a pair of dice for the user and the computer. 
 * Then compares the rolls to find who had the highest roll.
 */
import java.util.*;

public class DiceRoller 
{

		public static void main(String[] args)
		{
			Scanner scan = new Scanner(System.in);
			boolean play = true;
			PairOfDice dice = new PairOfDice(4);
			
			int myWins = 0;
			int compWins = 0;
			int ties = 0;
			String verdict = "";
			
			//Continues to roll until the user enters "n".
			while(play == true)
			{
				//my-user roll
				dice.roll();
				int myScore = dice.getTotal();
				String myRoll = dice.toString();
				
				//computer roll
				dice.roll();
				int compScore = dice.getTotal();
				String compRoll = dice.toString();
				
				if(myScore > compScore) 
				{
					myWins++;
					verdict = "You win!";
				}
				else if(myScore == compScore)
				{
					ties++;
					verdict = "Tie.";
				}
				else 
				{
					compWins++;
					verdict = "You lose!";
				}
				
				System.out.println("Your roll: " + myRoll + "\nComputer's roll: " + compRoll);
				System.out.println("\nYour wins:" + myWins + "\tComputer's wins: " + compWins + "\tTies: " + ties);
				System.out.println(verdict);				
				System.out.println("\nWould you like to play again? (y or n)");
				String yn = scan.nextLine();
				
				//off switch
				if(yn.charAt(0) == 'n')
				{
					play = false;
				}
			}
			scan.close();
		}
}
