import java.util.*;

/**
 * Demonstrates the use of a programmer-defined class.
 * @author Java Foundations
 */
public class SnakeEyes
{
   /**
    * Creates two Die objects and rolls them several times, counting
    * the number of snake eyes that occur.
    * 
    * @param args (unused)
    */
   public static void main (String[] args)
   {
      final int ROLLS = 500;
      int num1, num2, count = 0;
      Scanner scan = new Scanner(System.in);
      int numSides;
      System.out.print("How many sides per die? ");
      numSides = scan.nextInt();

      Die die1 = new Die(numSides);
      Die die2 = new Die(numSides);

      for (int roll = 1; roll <= ROLLS; roll++)
      {
         num1 = die1.roll();         
         num2 = die2.roll();
         
         //print the value of die1 and die2
         System.out.println("roll " + roll);
         
         System.out.println("die1 value: " + die1.getFaceValue());
         System.out.println("die2 value: " + die2.getFaceValue());
         
         System.out.println();
         
         if (num1 == 1 && num2 == 1)    // check for snake eyes
            count++;
      }
      System.out.println ("Number of rolls: " + ROLLS);
      System.out.println ("Number of snake eyes: " + count);
      System.out.println ("Ratio: " + (double)count / ROLLS);
      
      scan.close();
   }
}
