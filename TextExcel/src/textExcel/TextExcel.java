package textExcel;
import java.util.Scanner;

// Update this file with your own code.

public class TextExcel
{

	public static void main(String[] args)
	{
	    // Add your command loop here
		Scanner userinput = new Scanner(System.in);
    	String holder = ("");
    	
    	//Initialize spreadsheet
    	Spreadsheet spreadsheet = new Spreadsheet();
    	//TestsALL.Helper th = new TestsALL.Helper();
		//System.out.println(th.getText());
    	System.out.println("What location would you like");
		holder = userinput.nextLine();
		
    	//loop until user input is "quit"
    	while (!holder.toUpperCase().equals("QUIT")) {
    		System.out.println(spreadsheet.processCommand(holder));
    		System.out.println("What location would you like");
    		holder = userinput.nextLine();
    	}
    	userinput.close();
	}
}