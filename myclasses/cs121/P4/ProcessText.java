import java.io.File;
/**ProcessText.java
 * 
 * @author Ryan Thompson
 * 
 * The ProcessText class is the driver for the TextStatisics.java file.
 */
public class ProcessText 
{
	/**
	 * @param args
	 * 
	 * This is the main class for the driver.
	 * This class uses args as the parameter to 
	 * generate statistics for a given File.
	 */
	public static void main(String[] args)
	{
		if(args.length < 1)
		{
			System.out.println("Usage: java ProcessText file1 [file2 ...]");
			System.exit(1);
		}
		else
		{
			File[] file = new File[args.length];
			
			for(int z = 0; z < args.length; z++)
			{
				file[z] = new File(args[z]);
			
				if(file[z].exists() && file[z].isFile())
				{
					TextStatistics stats = new TextStatistics(file[z]);
					System.out.println(stats.toString());
				
					//---letter occurrences---//
					int[] letters = new int[26];
					letters = stats.getLetterCount();					
					System.out.println("------------------------------");
					for(int y = 0; y < 13; y++)
					{
						System.out.println( "" + ((char)(97+y)) + " = " + letters[y] + "\t\t"  + ((char)(97+y+13)) + " = " + letters[(y+13)]);
					}
					System.out.println("------------------------------");
					
					//---word length occurrences--//
					int[] wordLengths = new int[24];
					wordLengths = stats.getWordLengthCount();					
					System.out.println("Length\tFrequency");
					for(int i = 1; i < 24; i++)
					{
						if(wordLengths[i] != 0)
						{
							System.out.println("" + (0+i) + "\t" + wordLengths[i]);
						}
					}
				}
				else 
				{
					System.out.println("Usage: java ProcessText file1 [file2 ...]");
					System.exit(1);
				}
			}
		}
	}
}
