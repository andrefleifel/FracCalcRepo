package fracCalc;

import java.util.*;

public class FracCalc {

	public static void main(String[] args) { 
        // TODO: Read the input from the user and call produceAnswer with an equation
		Scanner userInput = new Scanner(System.in);
		boolean done = false;
		while(!done) {
			String formula = userInput.nextLine();
		
			if(formula.equals("quit")) {
				done = true;
			}
			else {
				String answer = produceAnswer(formula);
				System.out.println(answer);
			}
		}
    }
	// TODO: Read the input from the user and call produceAnswer with an equation



	// ** IMPORTANT ** DO NOT DELETE THIS FUNCTION. This function will be used to
	// test your code
	// This function takes a String 'input' and produces the result
	//
	// input is a fraction string that needs to be evaluated. For your program, this
	// will be the user input.
	// e.g. input ==> "1/2 + 3/4"
	//
	// The function should return the result of the fraction after it has been
	// calculated
	// e.g. return ==> "1_1/4"
	public static String produceAnswer(String input) {
		String[] operand =  input.split(" ");
		int[] operand1 = toImproperFrac(operand[0]);
		int[] operand2 = toImproperFrac(operand[2]);
		String operator = operand[1];
		int[] answer = new int[2];
		
		if(operator.equals("+") || operator.equals("-")) {
			answer = addSubtract(operand1, operand2, operator);
		
		}else if (operator.equals("*") || operator.equals("/")) {
			answer = multiplyDivide(operand1, operand2, operator);
		}
		String reducedAnswer = reduceAnswer(answer);
		return reducedAnswer;
	}
	
	
	public static int[] addSubtract (int[] operand1, int[] operand2, String operator) {
		int numerator = 0;
		
		if (operator.equals("+")) {
			numerator = (operand1[0] * operand2[1] + operand2[0] * operand1[1]);
			
		}else if (operator.equals("-")) {
			numerator = (operand1[0] * operand2[1] - operand2[0] * operand1[1]);
		}
		int denominator = operand1[1] * operand2[1];
		int[] answer = {numerator, denominator};
 		return answer;
	}

	public static int[] multiplyDivide (int[] operand1, int[] operand2, String operator) {
		int numerator = 0;
		int denominator = 0;
		if(operator.equals("*")) {
			numerator = (operand1[0] * operand2[0]);
			denominator = (operand1[1] * operand2[1]);
		}else if (operator.equals("/")) {
			if (operand2[0] < 0) {
				operand2[1] *= -1;
				operand2[0] *= -1;
			}
			numerator = (operand1[0] * operand2[1]);
			denominator = (operand1[1] * operand2[0]);
		}
		int[] answer = {numerator, denominator};
		return answer;
	}
	public static int[] toImproperFrac(String operand) {
		String whole = "";
		String numerator = "";
		String denominator = "";
		int underscore = operand.indexOf("_");
		int slash = operand.indexOf("/");
		
		if (operand.indexOf("_") >= 0) {
			
			whole = operand.substring(0 , underscore);
			numerator = operand.substring(underscore + 1, slash);
			denominator = operand.substring(slash + 1, operand.length());
		}else if ((operand.indexOf("_") < 0) && (operand.indexOf("/") >= 0)) {
			
			whole = "0";
			numerator = operand.substring(0 , slash);
			denominator = operand.substring(slash + 1, operand.length());
		}else if ((operand.indexOf("_") < 0) && (operand.indexOf("/") < 0)) {
			
			whole = operand;
			numerator = "0";
			denominator = "1";
		}
		int wholeNum = Integer.parseInt(whole.trim());
		int numer = Integer.parseInt(numerator.trim());
		int denom = Integer.parseInt(denominator.trim());
		int top;
		if(operand.substring(0,1).equals("-") && wholeNum != 0) {
			top = wholeNum * denom - numer;
		}else if (operand.substring(0,1).equals("-") && wholeNum == 0){
			top = numer;
		}else {
			top = wholeNum * denom + numer;
		} 
		int[] improper = {top, denom};
		return improper;
	}	
		
	public static String reduceAnswer(int[] operand) {
		int whole = operand[0] / operand[1];
		int numerator = operand[0] % operand[1];
		int denominator = (operand[1]);
		if (whole != 0) {
			numerator = Math.abs(numerator);
		}
		int gcf = gcf(numerator, denominator);
		numerator = numerator / gcf;
		denominator = denominator / gcf;
		if (denominator == 0) {
			return "ERROR: cannot divide by zero";
		}else if (whole == 0 && numerator == 0) { 
			return "0";
		}else if  (numerator == 0) {
			return "" + whole;
		}else if ( whole == 0) {
			return numerator +"/"+ denominator;
		}
		return whole +"_"+ numerator +"/"+ denominator;
	}
	
	/*
	 * This method takes 2 integers and return their greatest common factor. 
	 */
	public static int gcf(int num1, int num2) {
		num1 = Math.abs(num1);
		num2 = Math.abs(num2);
		for(int i = num1; i > 1; i--) {
			if(num1 % i == 0 && num2 % i ==0) {
				return i;
			}
		}
		return 1;
	}

}