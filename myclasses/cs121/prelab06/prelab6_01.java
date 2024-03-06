/*Pre lab question number 1
 * 
 *@author Ryan Thompson 
 * 
 * Prints the odd numbers from 1 to 99 using a for loop
 */

public class prelap6_01 
{
	public static void main(String[] args)
	{
		for(int x = 1; x < 100; x++)
		{
			if(x % 2 > 0) 
			{
				System.out.println(x);
			}
		}
	}
}
