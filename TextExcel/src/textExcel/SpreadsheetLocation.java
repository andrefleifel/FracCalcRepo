package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
	private int row;
	private int col;
	
	public SpreadsheetLocation() {
		row = 0;
		col = 0;
	}
	public SpreadsheetLocation(String cellName) {
		col = (cellName.toUpperCase()).charAt(0)-65; //gets the letter for the column
		row = Integer.parseInt(cellName.substring(1))-1; //gets the integer for the row
	}
	
	public SpreadsheetLocation (int row, int col) {
		this.col = col;
		this.row = row;
	}
	
    @Override
    public int getRow()
    {
        return row;
    }

    @Override
    public int getCol()
    {
        return col;
    }

}
