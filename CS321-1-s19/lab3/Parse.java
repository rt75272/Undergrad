import java.io.*;
import java.util.*;

public class Parse {
	private String word;
	private String current;
	private StringTokenizer tokenizer;
	private BufferedReader bufferedReader;

	public Parse(String file) throws IOException {
		if(file == null) {
			throw new IOException("File not found");
		} 
		else {
			FileReader fileRead = new FileReader(new File(file));
			bufferedReader = new BufferedReader(fileRead);
		}
		nextLine();
	}
	private void nextLine() throws IOException {
		int n = 0;
		while(n == 0) {
			current = bufferedReader.readLine();
			tokenizer = current != null ? tokenizer = new StringTokenizer(current)
			: new StringTokenizer("");
			if(tokenizer.hasMoreTokens() || current == null)
				n = 1;
		}
		word = current != null ? tokenizer.nextToken() : "";
	}
	public String nextWord() throws IOException {
		String str = word;
		if(!tokenizer.hasMoreTokens()) {
			nextLine();            
		} 
		else {
			word = tokenizer.nextToken();
		}
		return str;
	}
	public boolean hasWord() {
		return current != null;
	}
}