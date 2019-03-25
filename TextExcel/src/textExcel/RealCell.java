package textExcel;


public class RealCell implements Cell{
	
	private String contents;
	private double value;
	
	public RealCell(String userinput) { //real cell constructor for value cell
		 
		contents = userinput; //sets what ever the user inputed as the string contents
		
		if(userinput.contains("(") && userinput.contains(")")) {
			String temp = userinput.split(" ",3)[2];
		}
		else if( userinput.contains("%")) {
			value = (Double.parseDouble(userinput.substring(0, userinput.indexOf("%"))))/100;
		}
		else {
			value = Double.parseDouble(userinput);
		}
	}
	
	public String abbreviatedCellText() { // text for spreadsheet cell display, must be exactly length 10
		String tempcontents = contents + "          "; //adds 10 spaces to a temporary string 
		return (tempcontents.substring(0, 10)); //returns the first 10 characters in the temporary string, including spaces
	}

	public String fullCellText() {// text for individual cell inspection, not truncated or padded
		return contents;
	}
	public String getContents() { //returns contents in string "contents"
		return contents;
	}
	public double getValue() { //returns value in double for "value"
		return value;
	}
}