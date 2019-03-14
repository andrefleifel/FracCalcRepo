package textExcel;

public class ValueCell extends RealCell {
	
	public ValueCell(String input) {
		super(input);
	}

	@Override
	public String abbreviatedCellText() {
		String cellText = Double.toString(getDoubleValue());
		if( cellText.length() < 10) {
			if(!cellText.contains(".")) {
				cellText += ".0";
			}
			return addSpaces(cellText);
		}else{
			return cellText.substring(0, 10);
		}
	}

	@Override
	public String fullCellText() {
		return getRealCell();
	}

	@Override
	public double getDoubleValue() {
		return Double.parseDouble(getRealCell());
	}
}