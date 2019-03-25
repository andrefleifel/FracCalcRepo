package textExcel;

public class EmptyCell implements Cell {
	
	private String contents;
	
	//constructor for empty cell
	public EmptyCell() {
		contents  = "";
	}
	
	// text for spreadsheet cell display, must be exactly length 10
	public String abbreviatedCellText() {
		
		return "          ";
	}
	
	// text for individual cell inspection, not truncated or padded
	public String fullCellText() {
		
		return "";
	}
}