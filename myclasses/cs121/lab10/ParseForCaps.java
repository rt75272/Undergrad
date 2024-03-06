import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ParseForCaps 
{
		public static void main(String[] args)
		{
			Scanner scan = new Scanner(System.in);
			System.out.print("Enter a file name: ");
			String filename = scan.nextLine().trim();
			scan.close();
			File file = new File(filename);
			try 
			{
				Scanner fileScan = new Scanner(file);
				System.out.println("Contents of file: " + filename);
				char ch;
				System.out.print("Capital letters: ");
				while(fileScan.hasNextLine()) 
				{
					String lineScan = fileScan.nextLine();
					fileScan.useDelimiter(" ");
					int lineLength = lineScan.length();
					for(int i = 0; i < lineLength; i++)
					{
						ch = lineScan.charAt(i);
						if(Character.isUpperCase(ch))
						{
							System.out.print(lineScan.charAt(i));
						}
					}
				}
				fileScan.close();
			} catch (FileNotFoundException e) 
			{
				System.out.println("error\n" + e.getMessage());
			}
		}
}
