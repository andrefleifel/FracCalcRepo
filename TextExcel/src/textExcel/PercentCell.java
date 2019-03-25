package textExcel;

public class PercentCell extends RealCell implements Cell {

	private String contents;
	private double value;
	
	public PercentCell(String userinput) {
		super(userinput.split(" ")[2]);
		//splits the string EX: "A1 = 8.999%" and takes "8.999%", and  then
		//it turns inputs it into the super, RealCell constructor
		
		this.contents = super.getContents();
		this.value = super.getValue();
	}
	
	public String abbreviatedCellText() {
		return(super.abbreviatedCellText());
	}
	
	public String fullCellText() {
		return this.contents;
	}

}