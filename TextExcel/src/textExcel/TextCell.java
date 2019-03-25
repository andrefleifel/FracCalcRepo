package textExcel;

public class TextCell implements Cell{
	
	private String contents; // HOLD ONLY THE LETTER NOT INCLUDING THE QUOTES
	
	public TextCell(String userinput) { //constructor for the TextCell and sets the contents to the userinput
		contents = userinput; //sets the contents of the cell to the inputed string without the quotations
	}
	
	public String fullCellText() { //returns the fullCellText including the quotations
		return ("\"" + contents + "\""); //returns the full contents with quotations
	}
	
	public String abbreviatedCellText() { //returns only the first 10 words including spaces
		String tempcontents = contents + "          ";//ADD 10 SPACES AND JUST SUBSTRING TO 0-10, AND ALSO MAKE A TEMPORARY STRING FOR ABBREVIATED
		return tempcontents.substring(0, 10);
	}
}