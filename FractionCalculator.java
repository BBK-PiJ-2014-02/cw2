import java.util.*;

/**
 *  FractionCalculator: CW 2.
 */
public class FractionCalculator {
    /**
    *  Memory to be recalled at user's request
    */
    private Fraction memFraction;

    /**
    *  String memOperation
    */
    private String memOperation;

    /**
    *  Default Constructor.
    */
    public FractionCalculator() {
        initAllPrivateVariables();
        initialDisplay();
    }

    /**
    *  Constructor for displayValue only.
    */
    public FractionCalculator(Fraction display) {
        initAllPrivateVariables();
        initialDisplay();
    }

    /**
    *  Constructor for both displayValue and mem.
    */
    public FractionCalculator(Fraction display, Fraction mem) {
        initAllPrivateVariables();
        initialDisplay();
    }

    /**
    *  Resets all private variables to init values
    */
    private void initAllPrivateVariables() {
        this.memFraction  = new Fraction(0,1);
        this.memOperation = null;
    }

    /**
    *  Main method to launch the Calculator
    */
    static public void main(String[] args) {
        FractionCalculator fc = new FractionCalculator();
        fc.launch();
    }

    /**
    *  Launching the Calculator
    */
    public void launch() {
		// String to capture and process all user imput
        String inputString = "";

        // Carry Fraction to store value of previous calculation
        Fraction carry = new Fraction(0,1);

        // Loop forever until error or user instruction to quit is given.
        while(true) {

            // Get input from user with the calulation expression(s) to process
            inputString = System.console().readLine();

            // If inputString has nothing, continues
            if ( inputString == null || inputString.length() == 0 ) {
				System.out.print(">");
				continue;
			}

            // Don't need to evaluate if a quit request is given.
            if ( isQuit(inputString) ) {
                break;
            }

            evaluate(carry,inputString);

//            System.out.println("inputString = '" + inputString + "'");
//            System.out.println("carry = '" + carry.toString() + "'");
        };
    }

    /**
    *  Initial welcome display
    **/
    private void initialDisplay() {
        System.out.println("+------------------- Welcome to Vasco's calculator ------------------------+");
        System.out.println("|                                                                          |");
        System.out.println("| -- FUNCTION --+--------- ACTION ---------+------------ USAGE ----------- |");
        System.out.println("|               |                          |                               |");
        System.out.println("|  / * - +      | - Regular operations     |  2 + 3/4 * 5 - 6 / 6/7        |");
        System.out.println("|               |                          |  NOTE: 6 / 6/7 <=> 6/1 / 6/7  |");
        System.out.println("|               |                          |                               |");
        System.out.println("|  c|C|clear    | - Clear memory           |  c [ENTER]                    |");
        System.out.println("|  a|A|abs      | - Set VALUE to absolute  |  abs [ENTER]                  |");
        System.out.println("|  n|N|neg      | - Set VALUE to -VALUE    |  neg [ENTER]                  |");
        System.out.println("|               |                          |                               |");
        System.out.println("|  q|Q|quit     | - Quits Calculator       |  q [ENTER]                    |");
        System.out.println("|               |                          |                               |");
        System.out.println("+---------------+--------------------------+-------------------------------+");
        System.out.println("Please enter your calculations:");
        System.out.print("> ");
    }

    /**
    *  Evaluates the inputString taking faction from any previous calculations.
    */
    public void evaluate(Fraction fraction, String inputString) {
        // Split user given string by spaces to the process each element
        String[] elements = inputString.split(" ");

        // Process each element in turn to apply calculations
        for( int i = 0; i < elements.length; i++ ) {

			// Temporary Fraction
			Fraction tmpFraction = null;

			// Check if we have any basic operation to apply
            if ( isStringChars("+-*/",elements[i]) ) {

                // This must be a fraction
				if ( isStringChars("/",elements[i]) ) {
					System.out.println("Executing element: "+elements[i]);
					String[] strFraction = elements[i].split("/");
					tmpFraction = new Fraction(Integer.parseInt(strFraction[0]),Integer.parseInt(strFraction[1]));
					System.out.println("Fraction: "+tmpFraction.toString());

				}

            }

            else {
            }
        }
    }

    /**
    *  Check if function clear was entered
    *  c or C must be entered on their own to be accepted
    *  "clear" can exist at any point of str
    */
    private boolean isClear(String str) {

        if ( str.length() == 1 ) {
            if ( isStr("C",str) ) {
                return true;
            }
            else {
                return false;
            }
        }

        if ( str.length() > 1 && isStr("CLEAR",str) ) {
            return true;
        }

        return false;
    }

    /**
    *  Check if function abs was entered
    *  a or A must be entered on their own to be accepted
    *  "abs" can exist at any point of str
    */
     private boolean isAbs(String str) {

        if ( str.length() == 1 ) {
            if ( isStr("A",str) ) {
                return true;
            }
            else {
                return false;
            }
        }

        if ( str.length() > 1 && isStr("ABS",str) ) {
            return true;
        }

        return false;
    }

    /**
    *  Check if function neg was entered
    *  n or N must be entered on their own to be accepted
    *  "neg" can exist at any point of str
    */
    private boolean isNeg(String str) {

        if ( str.length() == 1 ) {
            if ( isStr("N",str) ) {
                return true;
            }
            else {
                return false;
            }
        }

        if ( str.length() > 1 && isStr("NEG",str) ) {
            return true;
        }

        return false;
    }

    /**
    *  Check if quit was requested
    *  q or Q must be entered on their own to be accepted
    *  "quit" can exist at any point of str
    */
    private boolean isQuit(String str) {

        if ( str.length() == 1 ) {
            if ( isStr("Q",str) ) {
                return true;
            }
            else {
                return false;
            }
        }

        if ( str.length() > 1 && isStr("QUIT",str) ) {
            return true;
        }

        return false;
    }

    /**
    *  isStr returns true if str1 is in str2
    */
    private boolean isStr(String str1, String str2) {
		return isStr(str1, str2, str1.length());
    }

    /**
    *  isStringChars returns true if any of the chars in str1 in str2
    */
    private boolean isStringChars(String str1, String str2) {
		return isStr(str1,str2,1);
    }

    /**
    *  Generic string comparison checking if str1 is found in str2
    *  Length states the str1 length word to check if in str2
    */
    private boolean isStr(String str1, String str2, int length) {
        if ( str1 == null || str2 == null || length == 0 ) {
            return false;
        }

        if ( length > 1 && str1.length() > str2.length() ) {
            return false;
        }

        // Convert it all to upper
        str2 = str2.toUpperCase();
        str1 = str1.toUpperCase();

        // Are we comparing all str1 with str2?
        if ( str1.length() == length ) {
            for ( int i = 0; i <= str2.length() - length; i++ ) {
                String cut = str2.substring(i,length+i);
                if ( str1.equals(cut) ) {
                    return true;
                }
            }
        }
        // In the case str1 is longer than the length of the word to check
        // Loop through each str1 word of length 'length' too.
        else {
			for ( int j = 0; j <= str1.length() - length; j++ ) {
				String str1Cut = str1.substring(j,length+j);
                for ( int i = 0; i <= str2.length() - length; i++ ) {
                    String cut = str2.substring(i,length+i);
                    if ( str1Cut.equals(cut) ) {
                        return true;
                    }
				}
            }
		}
        return false;
	}
}
