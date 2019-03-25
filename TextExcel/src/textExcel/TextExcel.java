package textExcel;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Update this file with your own code.

public class TextExcel
{

	public static void main(String[] args)
	{
		Scanner userInput = new Scanner (System.in); 
		Spreadsheet s = new Spreadsheet();
		Boolean done = false;
		while (!done) {
			String input = userInput.nextLine();
			
			if ( userInput.next().equals("quit")) {
				done = true;
			}else { 
				System.out.println(s.processCommand(input));
			}
		}
	}

}