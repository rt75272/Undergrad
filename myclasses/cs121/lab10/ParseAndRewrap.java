import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ParseAndRewrap 
{
	public static void main(String[] args)
	{
		//Getting the file from the user.
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a text file: ");
		String fileName = scan.nextLine().trim();
		
		File file = new File(fileName);
		
		System.out.print("Enter the max number of characters per line: ");
		int maxChar = scan.nextInt();
		
		scan.close();
		try
		{
			Scanner fileScan = new Scanner(file);
			System.out.println("\nfile contents: " + fileName + "\n");
			int charCount = 0;
			while(fileScan.hasNextLine())
			{
				fileScan.useDelimiter(" ");
				String line = fileScan.nextLine();
				Scanner lineScan = new Scanner(line);
				int lineLength = 0;
				while(lineScan.hasNext())
				{
					String token = lineScan.next();
					int tokenLength = token.length();
					lineLength += tokenLength+1;
					if(lineLength < maxChar) 
					{
						System.out.print(lineLength);
					}
					else 
					{
						lineLength = 0;
						System.out.println("");
					}
					
					System.out.print(token + " ");
				}
				/*int lineLength = line.length();                
				
				for(int i = 0; i < lineLength; i++)
				{
					System.out.print(line.charAt(i));
					charCount++;
					if(charCount==maxChar)
					{
						System.out.println("");
						charCount = 0;
					}
				}
				//System.out.print("");*/
			}
		}	
		catch(FileNotFoundException e)
		{
			System.out.println("Error\n" + e.getMessage());
		}
	}
}
