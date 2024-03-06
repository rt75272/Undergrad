/** Reverse String
 *
 * @author Ryan Thompson
 *
 * Reverses a string that the user enters
 */

import java.util.Scanner;



public class ReverseString {

        public static void main(String[] args)
        {
                Scanner scan = new Scanner(System.in);
                System.out.print("Enter a string: ");
                String userInput = scan.nextLine().trim();

                System.out.println("Your string: " + userInput);
                System.out.print("Your string reversed: ");

                for(int i = userInput.length()-1;i >= 0; i--)
                {
                        System.out.print(userInput.charAt(i));
                }
                scan.close();
        }

}
