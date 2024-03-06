import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.NumberFormat;
/**TextStatistics.java
 * 
 * @author Ryan Thompson
 *
 * Generates statistics for a given File variable
 */
public class TextStatistics implements TextStatisticsInterface
{
	private static final String DELIMITERS = "[\\W\\d_]+";
	int charCount;
	int lineCount;
	int wordCount;
	int totalWordLength;
	int[] letterCount;
	int[] wordCountLength;
	double avgWordLength;
	File fileX;
	DecimalFormat cleanFloat = new DecimalFormat("#0.00");	
	/**
	 * Constructor
	 * 
	 * @param File file
	 * 
	 * Takes in a File variable to get the statistics for the File.
	 * If the File is not valid, returns a message stating the usage 
	 * for this constructor. 
	 */
	public TextStatistics(File file)
	{
		fileX = file;
		try
		{
			Scanner fileScan = new Scanner(fileX).useDelimiter(DELIMITERS);
			charCount = (int) fileX.length();
			lineCount = 0;
			wordCount = 0;
			wordCountLength = new int[24];
			letterCount = new int[26];
			
			for(int x = 0; x < 24; x++)
			{
				wordCountLength[x]= 0;
			}		
			for(int j = 0; j < 26; j++)
			{
				letterCount[j] = 0;
			}				
			while(fileScan.hasNextLine())
			{
				String line = fileScan.nextLine();
				
				Scanner lineScan = new Scanner(line).useDelimiter(DELIMITERS);
				while(lineScan.hasNext())
				{
					String word = lineScan.next();
					word = word.toLowerCase();
					for(int i = 1; i < 24; i++)
					{
						if(word.length() == i)
						{
							wordCountLength[i]++;
						}
					}				
					for(int j = 0; j < word.length(); j++)
					{
						for(int n = 0; n < 26; n++)
						{
							char abc = ((char)(97+n));
							
							if(word.charAt(j) == abc)
							{
								letterCount[n]++;
							}
						}
					}			
					wordCount++;
					totalWordLength += word.length(); 
					avgWordLength = (double) totalWordLength/wordCount;
				}
				lineCount++;
			}
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Usage: java ProcessText file1 [file2 ...]");
		}
	}
	/**
	 * @return charCount
	 * charCount provides the number of characters in a give File.
	 */
	@Override
	public int getCharCount() {
		return charCount;
	}
	/**
	 * @return wordCount
	 * wordCount provides the number of words in a given File.
	 */
	@Override
	public int getWordCount() {
		return wordCount;
	}
	/**
	 * @return lineCount
	 * lineCount provides the number of lines in a given File.
	 */
	@Override
	public int getLineCount() {
		return lineCount;
	}
	/**
	 * @return letterCount
	 * letterCount provides the number of letters in a given File.
	 */
	@Override
	public int[] getLetterCount() {
		return letterCount;
	}
	/**
	 * @return wordCountLength
	 * wordCountLength provides the length of a word in a given File.
	 */
	@Override
	public int[] getWordLengthCount() {
		return wordCountLength;
	}
	/**
	 * @return avgWordLength
	 * avgWordLength provides the average word length in a given File.
	 */
	@Override
	public double getAverageWordLength() {
		return avgWordLength;
	}
	/**
	 * @return lineCount, wordCount, charCount, avgWordLength
	 * returns the lineCount, wordCount, charCount, and avgWordLength
	 * variables in string format.
	 */
	public String toString()
	{
		return lineCount + " lines\n"
			   + wordCount + " words\n"
			   + charCount + " characters\n"
			   + "Average word length = " + cleanFloat.format(avgWordLength);
	}
}
