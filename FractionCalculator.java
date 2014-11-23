import java.util.*;

/**
 *  FractionCalculator: CW 2.
 */
public class FractionCalculator {
    /**
     *  Valid Fraction characters.
     */
    private String VALID_FRACTION_CHARS = "0123456789-+";

    /**
     *  Store current error thrown.
     */
    private CalculatorErrors ERROR;

    /**
     *  Debug flag
     */
    private boolean DEBUG = false;

    /**
     *  Debug level 0 ( only top level ) - 10 ( all levels )
     */
    private int LEVEL = 10;

    /**
     *  Previous result
     */
    private Fraction memFraction;

    /**
     *  String memOperator
     */
    private String memOperator;

    /**
     *  Default Constructor.
     */
    public FractionCalculator() {
        reset();
    }

    /**
     *  Resets all private variables to init values
     */
    private void reset() {
        this.memFraction = new Fraction(0,1);
        this.memOperator = null;
        this.ERROR       = null;
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
        initialDisplay();

        // String to capture and process all user input
        String inputString = "";

        // Loop forever until error or user instruction to quit is given.
        while(true) {

            // Get input from user with the calulation expression(s) to process
            inputString = getInput();

            // If inputString has nothing, continues
            if ( inputString == null || inputString.length() == 0 ) {
                continue;
            }

            // Don't need to evaluate if a quit request is given.
            if ( isQuit(inputString) ) {
				print("Goodbye");
                break;
            }

            // Pass on previous memFraction value
            // and currently user requested expression
            evaluate(this.memFraction,inputString);

            // Check for any defined errors and display error or description on debug mode
            if ( ERROR != null ) {

				// Error when not in debug mode
                if ( ! DEBUG ) {
					print("Error");
                }

                // Be more precise on the type of error when in debug mode
                else {
					print("====> " + ERROR.toString() + " <====");
				}

				// Whenever an error occurs, reset the calculator
                reset();
            }
            // Display the results on the screen
            else {
				if ( this.memOperator != null ) {
					print(this.memFraction.toString() + " " + this.memOperator);
				}
				else {
					print(this.memFraction.toString());
                }
		    }

            // For debugging purposes only
            debug(0, " Fraction( " + memFraction.toString() + " ) Operator( " + memOperator + " )");
        };

    }

    /**
     *  Initial welcome display
     */
    private void initialDisplay() {
        System.out.println();
        System.out.println();
        System.out.println("======================= Welcome to Vasco's calculator ===========================");
        System.out.println("                                                                                 ");
        System.out.println("     FUNCTION              ACTION                          USAGE                 ");
        System.out.println("                |                          |                                     ");
        System.out.println("   / * - +      | - Regular operations     |  2 + 3/4 * 5 - 6 / 6/7              ");
        System.out.println("                |                          |  NOTE: 6 / 6/7 <=> 6/1 / 6/7        ");
        System.out.println("                |                          |                                     ");
        System.out.println("   c|C|clear    | - Clear memory           |  c   -- at any point to clear       ");
        System.out.println("   a|A|abs      | - Set VALUE to absolute  |  abs -- to apply on displayed value ");
        System.out.println("   n|N|neg      | - Set VALUE to -VALUE    |  neg -- to apply on displayed value ");
        System.out.println("                |                          |                                     ");
        System.out.println("   q|Q|quit     | - Quits Calculator       |  q   -- at any point to quit        ");
        System.out.println("                                                                                 ");
        System.out.println("=================================================================================");
        System.out.println("\nPlease enter your calculations:\n");
    }

    /**
     *  Debug printing results depending on debugging level set.
     */
    private void debug(int level, String str) {
        String spaces = "";
        for ( int i = 0; i < level; i++ ) {
            spaces += ".";
        }

        if ( DEBUG && LEVEL >= level ) {
            print("[ DEBUG ] " + level + " " + spaces + " " + str);
        }
    }

    /**
     *  Evaluates the inputString taking faction from any previous calculations.
     *  There is no precedence between +,- and /,* operators. The caculator executes
     *  each operation in the order it is by the inputString
     */
    public void evaluate(Fraction fraction, String inputString) {

        // Ensure the inputString is cleaned
        inputString = cleanInputString(inputString);

        // Ensure we have a valid fraction initialised with 0.
        if ( fraction == null ) fraction = new Fraction(0,1);

        // If evaluate is called from outside this class, memFraction must be initialise with
        // the given value as a starting point for calculation. For when running the calculator
        // using the main method from this class, the fraction will carry over to the next.
        this.memFraction = fraction;

        // Split user given string by spaces to the process each element
        String[] elements = inputString.split(" ");
        debug(1, "Input: " + elements.length + " element(s)");

        // Process each element in turn to apply calculations
        for( int i = 0; i < elements.length; i++ ) {
            debug(2, i + ": '" + elements[i] + "'");

            // Check if we have any basic operation to apply
            if ( isStringChars("+-*/",elements[i]) ) {
                debug(3, "has +-*/: "+elements[i]);

                // This must be a fraction if legnth > 1, i.e.: not '/' alone
                if ( isStringChars("/",elements[i]) && elements[i].length() > 1 ) {
                    debug(4, "is /: "+elements[i]);

                    String[] strFraction = elements[i].split("/");
                    int numerator   = 0;
                    int denominator = 1;

                    if ( isValidFraction(strFraction) ) {

                        numerator   = Integer.parseInt(strFraction[0]);

                        if ( strFraction.length > 1 ) {
                            denominator = Integer.parseInt(strFraction[1]);
                        }

                        debug(4, "Converted num/den = "+numerator+"/"+denominator);

                        // Two scenarios:
                        // 1 - memOperator is null -> store this in memFraction
                        // 2 - memOperator is not null -> execute operation
                        if ( this.memOperator == null ) {
                            this.memFraction = new Fraction(numerator, denominator);
                            debug(5, "No operation. Assign to memFraction: "+ this.memFraction.toString() );
                            continue;
                        }
                        else {
                            debug(5, "execute("+this.memFraction.toString()+this.memOperator+
                                (new Fraction(numerator, denominator)).toString() + ")");

                             // Executing the operation between the two fractions
                            execute(this.memFraction,new Fraction(numerator, denominator));

                            continue;
                        }
                    }
                    else {
                        error(CalculatorErrors.INVALID_FRACTION);
                        break;
                    }
                }

                // It is a [/*-+] on it's own: set operation
                if ( elements[i].length() == 1 ) {

                    if ( this.memOperator != null ) {
                        error(CalculatorErrors.OPERATOR_OVERRIDE);
                        debug(4, "memOperation has '" + this.memOperator + "' setting with: '" + elements[i] + "'");
                        break;
                    }
                    else {
                        debug(4, "setting memOperation with: " + elements[i]);
                        this.memOperator = elements[i];
                    }
                }

                // -1 or *1 or +1 should still be considered here: loaded into memFraction without question
                else if ( isOnlyStringChars("-+0123456789",elements[i]) && !isMoreThanOnce("+-",elements[i]) && elements[i].length() > 1 ) {
					this.memFraction = new Fraction(Integer.parseInt(elements[i]),1);
					continue;
                }

                // Reject any other operations
                else {
                    error(CalculatorErrors.INVALID_OPERATION);
                    break;
                }
            }

            // Confirmed that no +-*/ exists. Check for ABS
            else if ( isAbs(elements[i]) ) {
                debug(3, "Requested ABS: " + elements[i] + " of " + this.memFraction.toString());
                executeAbs();
                debug(3, "ABS: " + this.memFraction.toString());
            }

            // Confirmed that no +-*/ exists. Check for CLEAR
            else if ( isClear(elements[i]) ) {
                debug(3, "Requested CLEAR: " + elements[i] + " of " + this.memFraction.toString());
                executeClear();
                debug(3, "CLEAR: " + this.memFraction.toString());
            }

            // Confirmed that no +-*/ exists. Check for NEG
            else if ( isNeg(elements[i]) ) {
                debug(3, "Requested NEG: " + elements[i] + " of " + this.memFraction.toString());
                executeNeg();
                debug(3, "NEG: " + this.memFraction.toString());
            }

            // When only numbers exist, Int parse those and add to the numerand of a new Fraction
            // if memOperator exists, execute the operation, otherwise, store in memFraction regardless
            else if ( isStringChars("0123456789",elements[i]) ) {

                debug(3, "Confirmed number: " + elements[i]);
                if ( this.memOperator != null ) {
                    execute(this.memFraction,new Fraction(Integer.parseInt(elements[i]),1));
                }
                else {
                    debug(4, "No operator. Assign to memFraction: " +
                        ( new Fraction(Integer.parseInt(elements[i]),1).toString())
                    );
                    this.memFraction = new Fraction(Integer.parseInt(elements[i]),1);
                }
            }
            else {
                error(CalculatorErrors.UNKNOWN_OPERATOR);
                break;
            }
        }
    }

    /**
     * Execute Abs to the memFraction value
     */
    private void executeAbs() {
        this.memFraction = this.memFraction.absValue();
    }

    /**
     * Execute Abs to the memFraction value
     */
    private void executeClear() {
        this.memFraction = new Fraction(0,1);
        this.memOperator = null;
    }

    /**
     * Execute Negation to the memFraction value
     */
    private void executeNeg() {
        this.memFraction = this.memFraction.negate();
    }

    /**
     *  execute(fraction,fraction) using the memOperator stored.
     */
    private void execute(Fraction f1, Fraction f2) {
        if ( this.memOperator == null ) {
            error(CalculatorErrors.NO_OPERATOR_DEFINED);
            return;
        }

        // Auxiliar Fraction to store operation result.
        Fraction res = null;

        switch (this.memOperator) {
            case "+" : {
                res = f1.add(f2);
                break;
            }
            case "-" : {
                res = f1.subtract(f2);
                break;
            }
            case "*" : {
                res = f1.multiply(f2);
                break;
            }
            case "/" : {
                res = f1.divide(f2);
                break;
            }
            default : {
                // If not known operator, stores the error and exists.
                error(CalculatorErrors.UNKNOWN_OPERATOR);
                return;
            }
        };

        debug(5,"EXEC: " + f1.toString() + " " + this.memOperator + " " + f2.toString() + " = " + res.toString());

        // Store restult in memFraction.
        this.memFraction = res;

        // Reset operation just executed.
        this.memOperator = null;
    }

    /**
     *  Get the input line from user
     */
    private String getInput() {
        System.out.print("> ");
        return cleanInputString(System.console().readLine());
    }

    /**
     *  Clean input String
     */
    private String cleanInputString(String str) {
        if ( str != null ) {
            // Clear any initial spaces
            while ( str.charAt(0) == ' ' ) {
                str = str.substring(1);
            }
        }
        return str;
    }

    /**
     *  Print a message in the calculator style
     */
    private void print(String msg) {
		if ( DEBUG ) {
            System.out.println(" "+msg);
		}
		else {
            System.out.print(msg+" ");
		}
    }

    /**
     *  Get the error if any for when Testing results
     */
    public CalculatorErrors getError() {
        return this.ERROR;
    }

    /**
     *  Get current Calcalcator memory status
     */
    public Fraction getMemFraction() {
        return this.memFraction;
    }

    /**
     *  Checks if the supplied two valued array corresponds
     *  to a valid Fraction numerator and denominator.
     *  Returns true if valid.
     */
    private boolean isValidFraction(String[] strFraction) {
        // Not valid if null
        if ( strFraction == null ) {
			return false;
		}

        // Not valid if length is zero
        if ( strFraction.length == 0 ) {
			return false;
		}

        // Not valid if length is more than 2
        if ( strFraction.length > 2 ) {
			return false;
		}

        // Cannot workout with: "/4"
        if ( strFraction[0].length() == 0 ) {
			return false;
		}

        // Cannot workout with: "4/"
        if ( strFraction[1].length() == 0 ) {
			return false;
		}

        // Checking for cases like "£%%$+-*+4/8"
        if ( strFraction[0].length() > 0 && !isOnlyStringChars(VALID_FRACTION_CHARS,strFraction[0]) ) {
			return false;
		}

        // Returning false for cases like "4/$W^$£$93"
        if ( strFraction[1].length() > 0 && !isOnlyStringChars(VALID_FRACTION_CHARS,strFraction[1]) ) {
			return false;
		}

        // Check for ++ or +- or -- or +++-*/. Only accepts one + or -
        if ( isMoreThanOnce("+-",strFraction[0]) || isMoreThanOnce("+-",strFraction[1]) ) {
			return false;
		}

        return true;
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
     *  If total of all chars in str1 are found more than once in str2, returns false
     */
    private boolean isMoreThanOnce(String str1, String str2) {
		if ( str1 == null ) return false;
		if ( str2 == null ) return false;

        // To count for each char of str1, how many exist in str2
        int times = 0;

		for( int i = 0; i < str2.length(); i++ ) {
			if ( isStr(""+str2.charAt(i),str1) ) {
				for( int j = 0; j < str1.length(); j++ ) {
					if ( str1.charAt(j) == str2.charAt(i) ) {
						times++;
					}
				}
			}
		}

		if ( times > 1 ) return true;

		return false;
    }

    /**
     * If the given string str2 does not have ONLY the chars found in str1,
     * returns false.
     */
    private boolean isOnlyStringChars(String str1, String str2) {
		if ( str1 == null ) return false;
		if ( str2 == null ) return false;

        // Go over str2 chars
        for ( int i = 0; i < str2.length(); i++ ) {
            // Only need to find one case for str2 not in str1
            if ( ! isStr( ""+str2.charAt(i), str1) ) {
				return false;
			}
		}
        return true;
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

    /**
     *  Sets the error
     */
    private void error(CalculatorErrors ce) {
        this.ERROR = ce;
    }
}
