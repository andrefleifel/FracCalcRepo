package textExcel;

public class FormulaCell extends RealCell implements Cell{

	private String contents;
	private double value;
	
	
	public FormulaCell(String userinput) {
		super(userinput);
	}
	
	public String abbreviatedCellText() {
		
	}
	
	public String fullCellText() {
		
	}
}