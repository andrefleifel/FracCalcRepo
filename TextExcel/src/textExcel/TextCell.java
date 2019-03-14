package textExcel;

public class TextCell implements Cell{

	private String word;
	public TextCell(String word) {
		this.word = word;
	}
@Override
public String abbreviatedCellText() {
	String cellText = word.substring(1,word.length()-1);

	if(cellText.length() < 10) {
		while(cellText.length() < 10) {
			cellText += " ";
		}
		return cellText;
	}else {
		return (cellText.substring(0,10));
	}
}

@Override
public String fullCellText() {
	return (word);
}
}