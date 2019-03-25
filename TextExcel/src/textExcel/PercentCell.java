package textExcel;

public class PercentCell extends RealCell{

	public PercentCell(String input) {
		super(input);
	}

	@Override
	public String abbreviatedCellText() {										//returns only percent with integer
		int decimal = getRealCell().indexOf(".");
		String wholeNumber = getRealCell().substring(0, decimal);
		if(wholeNumber.length() < 10) {
			wholeNumber += "%";
			return super.addSpaces(wholeNumber);
		}else {
			return (wholeNumber.substring(0, 8) + "%");
		}
	}

	@Override
	public String fullCellText() {
		return getDoubleValue() + "";
	}

	@Override
	public double getDoubleValue() {														//returns percent in decimal form
		String percent = getRealCell().substring(0, getRealCell().length() - 1);
		double realPercent = Double.parseDouble(percent) / 100.0;
		return realPercent;
	}

}