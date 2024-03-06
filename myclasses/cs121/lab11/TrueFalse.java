import java.util.Arrays;

/**@title TrueFalse.java
 * 
 * @author Ryan Thompson
 *
 * @description: Uses a command-line statement to build 
 * a boolean array with alternating true/false values.
 * Then assigns that array to new array through another method.
 */
public class TrueFalse 
{
	private static boolean[] copyArray(boolean[] original) 
	{
		boolean[] copy = original;
		return copy;
	}
	public static void main(String[] args)
	{
		int capacity;
		boolean[] flags;
		boolean[] arrayToPrint = {};
		
		if(args.length == 1)
		{
			try
			{
				capacity = Integer.parseInt(args[0]);
				flags = new boolean[capacity];
					
				for(int i = 0; i < capacity; i++) 
				{
					if(i % 2 == 0)
					{
						flags[i] = true;
						arrayToPrint = copyArray(flags);
					}
				}
				System.out.println("length: " + capacity);
				System.out.println(Arrays.toString(arrayToPrint));
			}
			catch(NumberFormatException e)
			{
				System.out.println("USAGE: TrueFalse <capacity>");
			}
		}
		else 
		{
			System.out.println("USAGE: TrueFalse <capacity>");
		}
	}
}

