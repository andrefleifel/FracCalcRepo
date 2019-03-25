
package textExcel;

public class ValueCell extends RealCell implements Cell{

	private String contents;
	private double value;
	
	public ValueCell(String userinput) {
		super(userinput.split(" ")[2]); //splits the command EX. "A1 = 213", sends "213" into the real cell constructor
		this.contents = super.getContents();
		this.value = super.getValue();
	}
	
	public String fullCellText() { //returns all of the contents 
		return contents;
	}
	
	public String abbreviatedCellText() {
		return (super.abbreviatedCellText());
	}
	
	public double getValue() {
		return this.value;
	}
}