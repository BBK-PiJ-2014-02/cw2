import java.util.*;

/**
 *  FractionCalculator: CW 2.
 */
public class FractionCalculator {
	/**
	*  Value carried over from previous calculation
	*/
	private Fraction carry;

	/**
	*  Memory to be recalled at user's request
	*/
	private Fraction mem;

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
		this.carry        = new Fraction(0,1);
		this.mem          = new Fraction(0,1);
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
        Scanner sc = new Scanner(System.in);
        String inputString;

        // Get input from user for operations or actions
        while(true) {

            inputString = sc.next();

            // Don't want to evaluate if with a quit request.
            if ( isQuit(inputString) ) {
                break;
            }

            evaluate(carry,inputString);

            System.out.println("inputString = '" + inputString + "'");
            System.out.println("carry = '" + carry.toString() + "'");
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
        if ( str1 == null || str2 == null ) {
            return false;
        }

        if ( str1.length() > str2.length() ) {
            return false;
        }
        int str1Length = str1.length();

        // Convert it all to upper
        str2 = str2.toUpperCase();
        str1 = str1.toUpperCase();

        for ( int i = 0; i <= str2.length() - str1Length; i++ ) {
            String cut = str2.substring(i,str1Length+i);
            if ( str1.equals(cut) ) {
                return true;
            }
        }
        return false;
    }
}
