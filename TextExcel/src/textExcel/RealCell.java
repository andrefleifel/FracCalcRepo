package textExcel;

public abstract class RealCell implements Cell {
	
	private String input;
	
	public RealCell(String input) {
		this.input = input;
	}
	
	public abstract String abbreviatedCellText();
	
	public abstract String fullCellText();
	
	public abstract double getDoubleValue();
	
	public String getRealCell() {
		 return input;
	 }
	 
	 public String addSpaces(String text) {
		 while(text.length() < 10) {
			 text += " ";
		 }
		 return text;
	 }
}
