package textExcel;

public class FormulaCell extends RealCell{
	
	private Spreadsheet grid;
	public FormulaCell(String input, Spreadsheet grid) {
		super(input);
		this.grid = grid;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String abbreviatedCellText() {
		String text = getDoubleValue() + "";
		if(text.length() < 10) {							//add spaces so cell is ten spaces
			return addSpaces(text);
		}else {
			return text.substring(0,10);
		}
	}

	@Override
	public String fullCellText() {
		return getRealCell();
	}

	//this method returns double value of cell after calculating formula
	public double getDoubleValue() {
		String formula = getRealCell().substring(2, getRealCell().length()-2);		//removes (), "A1 + B4"
		String[] arr = formula.split(" ");											//split by spaces 
		double result;
		String firstElement = arr[0];														//first element of array
		if(firstElement.toLowerCase().equals("sum")) {										//sum of numbers
			result = sum(arr[1].toLowerCase());
		}else if(firstElement.toLowerCase().equals("avg")) {								//averages numbers
			result = avg(arr[1].toLowerCase());
		}else{
			result = getCellValue(firstElement);												//if there is only one cell reference, it will find the values in that cell.
		}

		if(arr.length != 1) {	
			for(int j = 1; j < arr.length; j+=2) {	
				if(arr[j].equals("+")){												//add
					result += getCellValue(arr[j+1]);
				}else if(arr[j].equals("-")) {										//subtract
					result -= getCellValue(arr[j+1]);
				}else if(arr[j].equals("*")){										//multiply
					result *= getCellValue(arr[j+1]);
				}else if(arr[j].equals("/")){										//divide
					result /= getCellValue(arr[j+1]);
				}
			}
		}
		return result;
	}
//Mark Ding helped me with this method
	public double getCellValue(String cellName) {												//Finds value of other cell
		if(!(Character.isDigit(cellName.charAt(0))) && !(cellName.charAt(0) == '-')){			//determines if formula references a cell or is an actual number.
			RealCell c = (RealCell) grid.getCell(new SpreadsheetLocation(cellName));			//gets cell from grid and cast into RealCell.
			return c.getDoubleValue();															//return value of cell		
		}else {								
			return Double.parseDouble(cellName);
		}	
	}

//this method takes the average of cells user inputs	
 double avg(String formula) {
		String[] operands = formula.split("-");	
		int firstNum = Integer.parseInt(operands[0].substring(1));
		int lastNum = Integer.parseInt(operands[1].substring(1));
		char firstLetter = operands[0].charAt(0);
		char lastLetter = operands[1].charAt(0);
		double sum1 = sum(formula);													//finds sum of group of cells
		int totalCol = (lastLetter - firstLetter) + 1;
		int totalRow = (lastNum - firstNum) + 1;
		return sum1/(totalCol * totalRow);											// divide by the total number of cells
	}
 
 //this method takes the value of cells inputed and adds them together
 public double sum(String formula) {
		String[] operands = formula.toLowerCase().split("-");							//separate the two ends
		char firstLetter = operands[0].charAt(0);
		char lastLetter = operands[1].charAt(0);
		int firstNum = Integer.parseInt(operands[0].substring(1));
		int lastNum = Integer.parseInt(operands[1].substring(1));
		double sum = 0;
		
		for(char i = firstLetter; i <= lastLetter; i++) {
			for(int j = firstNum; j <= lastNum; j++) {
				SpreadsheetLocation loc = new SpreadsheetLocation("" + i + j);		//since i and j are not strings, put "" to cast into string
				Cell cell = grid.getCell(loc);										//get cells from the original grid
				if(cell instanceof RealCell) {
					RealCell temp = (RealCell)(cell);								//casts Cell into RealCell.
					sum += temp.getDoubleValue();									//add values from each cell.
				}
			}
		}
		return sum;
	}
}