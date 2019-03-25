package textExcel;

import java.util.ArrayList;
import java.util.List;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	private Cell[][] Arrayspreadsheet;
	private int row;
	private int col;
	private Location loc;

// create a constructor for Spreadsheet
	public Spreadsheet(){
		row = 20;
		col = 12;
		//initializes a 2D array of 20 rows & 12 columns
		Arrayspreadsheet = new Cell[row][col]; //12 Alphabets and 20 #'s
		for(int rownum = 0; rownum < row; rownum++) { //turns all of the 2D array into empty cells
			for(int colnum = 0; colnum < col; colnum++) {
				Arrayspreadsheet[rownum][colnum] = new EmptyCell();
			}
		}
	}
	@Override
	public String processCommand(String command)
	{
		if (command.contains("=") ==true){ //check if cell assignment
			loc = new SpreadsheetLocation(command.split(" ")[0]);
			return cellAssignment(command);
		}
		else {
			if (command.toLowerCase().contains("clear") == true) {
				if(command.length() == 5) {
					loc = new SpreadsheetLocation();
					return clearGrid();
				}
				else {
					loc = new SpreadsheetLocation(command.split(" ")[1]);
					return clearCell(command.split(" ")[1]);
				}
			}
			else{
				loc = new SpreadsheetLocation (command);
				return cellInspection(command);
			}
		}
	}
	
	public String clearCell(String inputedcell) {
		SpreadsheetLocation cellLocation = new SpreadsheetLocation(inputedcell); //creates a temporary cell location
		Arrayspreadsheet[cellLocation.getRow()][cellLocation.getCol()] = new EmptyCell(); //sets the inputed cell location contents to an empty cell clearing it
		return getGridText(); //reprints the grid with updated cells
	}
	
	
	public String clearGrid() { //clearing grid method
		for(int rownum = 0; rownum < row; rownum++) { //turns all of the 2D array into empty cells
			for(int colnum = 0; colnum < col; colnum++) {
				Arrayspreadsheet[rownum][colnum] = new EmptyCell(); //sets all to empty cells that have blank contents
			}
		}
		return getGridText(); //reprints the grid with updated cells
	}

	@Override
	public int getRows()
	{
		// TODO Auto-generated method stub
		return row;
	}

	@Override
	public int getCols()
	{
		// TODO Auto-generated method stub
		return col;
	}

	@Override
	public Cell getCell(Location loc) {
		return Arrayspreadsheet[loc.getRow()][loc.getCol()]; //returns the cell at the given/inputed location
	}
	
	public String getGridText()
	{
		String output = "";
		output += "   |";
		for(char c = 'A'; c < 'M'; c++) { //print out the column labels at the top
			output+= c + "         |"; //add each letter to the header
		}
		output+= "\n"; // next line after column header
		
		for (int rows = 0; rows < 20; rows++ ) {
			String temp = (rows + 1) + "   "; //sets the name for the rows
			output+= temp.substring(0, 3) + "|";
			for(int cols = 0; cols < 12 ; cols++) {
				output += (Arrayspreadsheet[rows][cols].abbreviatedCellText()) + "|";
				
			}
			output+= "\n"; //next row
		}
		return output;
	}
	
	public String cellInspection(String cellinput) { //returns the full text of what is in the cell at the inputed location/cell
		SpreadsheetLocation cellLoc = new SpreadsheetLocation(cellinput); //creates a new instance for the cellinput
		return getCell(cellLoc).fullCellText(); //calls fullText method of that instance of the cell
	}
	
	public String cellAssignment(String userinput) {
		
		String value = ""; //holds the user-inputed assignment
		
		String cellLoc = userinput.split(" ")[0];
		SpreadsheetLocation cellLocation = new SpreadsheetLocation(cellLoc); 
		//creates a temporary cell location
		
		
		if(userinput.contains("\"") && userinput.contains("\"")) {
			value = userinput.substring(userinput.indexOf("\"")+1, userinput.lastIndexOf("\""));
			
			
			Arrayspreadsheet[cellLocation.getRow()][cellLocation.getCol()] = new TextCell(value); 
			//sets the inputed cell location contents to a text cell with the inputed string value
		}
		else if(userinput.contains("(") && userinput.contains(")")){
			cellLoc = userinput.split(" ",3)[0];
		}
		
		
		return getGridText(); // prints the grid with updated cell
	}

}