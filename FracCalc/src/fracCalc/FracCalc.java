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
	
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input)
    { 
        // TODO: Implement this function to produce the solution to the input
        String[] fractionDecomposed = input.split(" ");
        String firstOperand = fractionDecomposed[0];
        String operator = fractionDecomposed[1];
        String secondOperand = fractionDecomposed[2];
        
        return secondOperand;
    }
    
    

    
    // TODO: Fill in the space below with any helper methods that you think you will need
    
}


