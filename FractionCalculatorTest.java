/**
 *  FractionCalculatorTest: CW 2.
 */
public class FractionCalculatorTest {

    static public void main( String[] args ) {

        // Course work example tested step by step
        test(new Fraction( 0, 1), "1/2 - 3/4", new Fraction(-1,4),null);
        test(new Fraction(-1, 4), "* abs", new Fraction(1,4),null);
        test(new Fraction( 1, 4), "8 7/8 neg +", new Fraction(-7,8),null);
        test(new Fraction( 0, 1), "3/4", new Fraction(3,4),null);
        test(new Fraction( 3, 4), "+ 1/-3", new Fraction(5,12),null);
        test(new Fraction( 5,12), "* 7", new Fraction(35,12),null);
        test(new Fraction(35,12), "/ 5", new Fraction(7,12),null);

        // Course work examples tested in one go
        test(new Fraction( 0, 1), "1/2 - 3/4 * abs 8 7/8 n +", new Fraction(-7,8),null);
        test(new Fraction( 0, 1), "3/4 + 1/-3 * 7 / 5", new Fraction(7,12),null);

        // ABS
        test(new Fraction(-8, 3), "abs", new Fraction(8,3),null);
        test(new Fraction( 8,-3), "abs", new Fraction(8,3),null);
        test(new Fraction(-8,-3), "abs", new Fraction(8,3),null);
        test(new Fraction(-8, 3), "abs * 3/8", new Fraction(1,1),null);
        test(new Fraction(-8, 3), "abs * -3/8", new Fraction(-1,1),null);
        test(new Fraction(-8, 3), "abs * -3/-8", new Fraction(1,1),null);
        test(new Fraction(-8, 3), "abs * 3/-8", new Fraction(-1,1),null);
        test(new Fraction(-8, 3), "a", new Fraction(8,3),null);
        test(new Fraction( 8,-3), "a", new Fraction(8,3),null);
        test(new Fraction(-8,-3), "a", new Fraction(8,3),null);
        test(new Fraction(-8,-3), "a 1", new Fraction(1,1),null);
        test(new Fraction(-8,-3), "a -1", new Fraction(-1,1),null);
        test(new Fraction(-8,-3), "a +1", new Fraction(1,1),null);
        test(new Fraction(-8,-3), "a * 1", new Fraction(8,3),null);
        test(new Fraction(-8, 3), "a * 3/8", new Fraction(1,1),null);
        test(new Fraction(-8, 3), "a * -3/8", new Fraction(-1,1),null);
        test(new Fraction(-8, 3), "a * -3/-8", new Fraction(1,1),null);
        test(new Fraction(-8, 3), "a * 3/-8", new Fraction(-1,1),null);
        test(new Fraction( 0, 1), "-3/4 a + 2", new Fraction(11,4),null);

        // NEG
        test(new Fraction(-8,3), "neg", new Fraction(8,3),null);
        test(new Fraction(8,-3), "neg", new Fraction(8,3),null);
        test(new Fraction(-8,-3), "neg", new Fraction(-8,3),null);
        test(new Fraction(-8,3), "neg * 3/8", new Fraction(1,1),null);
        test(new Fraction(-8,3), "neg * -3/8", new Fraction(-1,1),null);
        test(new Fraction(-8,3), "neg * -3/-8", new Fraction(1,1),null);
        test(new Fraction(-8,3), "neg * 3/-8", new Fraction(-1,1),null);
        test(new Fraction(-8,3), "n", new Fraction(8,3),null);
        test(new Fraction(8,-3), "n", new Fraction(8,3),null);
        test(new Fraction(-8,-3), "n", new Fraction(-8,3),null);
        test(new Fraction(-8,3), "n * 3/8", new Fraction(1,1),null);
        test(new Fraction(-8,3), "n * -3/8", new Fraction(-1,1),null);
        test(new Fraction(-8,3), "n * -3/-8", new Fraction(1,1),null);
        test(new Fraction(-8,3), "n * 3/-8", new Fraction(-1,1),null);
        test(new Fraction(0,1), "3/4 n + 2", new Fraction(5,4),null);

        // CLEAR
        test(new Fraction(-8,3), "clear", new Fraction(0,1),null);
        test(new Fraction(-8,3), "clear -8/9", new Fraction(-8,9),null);
        test(new Fraction(-8,3), "clear -8/9 + 9", new Fraction(73,9),null);
        test(new Fraction(-8,3), "c", new Fraction(0,1),null);
        test(new Fraction(-8,3), "c -8/9", new Fraction(-8,9),null);
        test(new Fraction(-8,3), "c -8/9 + 9", new Fraction(73,9),null);
        test(new Fraction( 0,1), "3/4 c + 2", new Fraction(2,1),null);

        // QUIT - Quit is only a function of the launched FractionCalculator.
        test(new Fraction(-8,3), "q -8/9 + 9", new Fraction(7,9),CalculatorErrors.UNKNOWN_OPERATOR);

        // +
        test(new Fraction(-8, 5), " + 4/5",   new Fraction( 4,-5),null);
        test(new Fraction( 8, 5), " + 4/5",   new Fraction(12, 5),null);
        test(new Fraction( 8,-5), " + 4/5",   new Fraction( 4,-5),null);
        test(new Fraction(-8,-5), " + 4/5",   new Fraction(12, 5),null);
        test(new Fraction(-8, 5), " + -4/5",  new Fraction(12,-5),null);
        test(new Fraction( 8, 5), " + -4/5",  new Fraction( 4, 5),null);
        test(new Fraction( 8,-5), " + -4/5",  new Fraction(12,-5),null);
        test(new Fraction(-8,-5), " + -4/5",  new Fraction( 4, 5),null);
        test(new Fraction(-8, 5), " + 4/-5",  new Fraction(12,-5),null);
        test(new Fraction( 8, 5), " + 4/-5",  new Fraction( 4, 5),null);
        test(new Fraction( 8,-5), " + 4/-5",  new Fraction(12,-5),null);
        test(new Fraction(-8,-5), " + 4/-5",  new Fraction( 4, 5),null);
        test(new Fraction(-8, 5), " + -4/-5", new Fraction( 4,-5),null);
        test(new Fraction( 8, 5), " + -4/-5", new Fraction(12, 5),null);
        test(new Fraction( 8,-5), " + -4/-5", new Fraction( 4,-5),null);
        test(new Fraction(-8,-5), " + -4/-5", new Fraction(12, 5),null);

        // -
        test(new Fraction(-8, 5), " - 4/5",   new Fraction(12,-5),null);
        test(new Fraction( 8, 5), " - 4/5",   new Fraction( 4, 5),null);
        test(new Fraction( 8,-5), " - 4/5",   new Fraction(12,-5),null);
        test(new Fraction(-8,-5), " - 4/5",   new Fraction( 4, 5),null);
        test(new Fraction(-8, 5), " - -4/5",  new Fraction( 4,-5),null);
        test(new Fraction( 8, 5), " - -4/5",  new Fraction(12, 5),null);
        test(new Fraction( 8,-5), " - -4/5",  new Fraction( 4,-5),null);
        test(new Fraction(-8,-5), " - -4/5",  new Fraction(12, 5),null);
        test(new Fraction(-8, 5), " - 4/-5",  new Fraction( 4,-5),null);
        test(new Fraction( 8, 5), " - 4/-5",  new Fraction(12, 5),null);
        test(new Fraction( 8,-5), " - 4/-5",  new Fraction( 4,-5),null);
        test(new Fraction(-8,-5), " - 4/-5",  new Fraction(12, 5),null);
        test(new Fraction(-8, 5), " - -4/-5", new Fraction(12,-5),null);
        test(new Fraction( 8, 5), " - -4/-5", new Fraction( 4, 5),null);
        test(new Fraction( 8,-5), " - -4/-5", new Fraction(12,-5),null);
        test(new Fraction(-8,-5), " - -4/-5", new Fraction( 4, 5),null);

        // /
        test(new Fraction(-8, 5), " / 4/5",   new Fraction( 2,-1),null);
        test(new Fraction( 8, 5), " / 4/5",   new Fraction( 2, 1),null);
        test(new Fraction( 8,-5), " / 4/5",   new Fraction( 2,-1),null);
        test(new Fraction(-8,-5), " / 4/5",   new Fraction( 2, 1),null);
        test(new Fraction(-8, 5), " / -4/5",  new Fraction( 2, 1),null);
        test(new Fraction( 8, 5), " / -4/5",  new Fraction( 2,-1),null);
        test(new Fraction( 8,-5), " / -4/5",  new Fraction( 2, 1),null);
        test(new Fraction(-8,-5), " / -4/5",  new Fraction( 2,-1),null);
        test(new Fraction(-8, 5), " / 4/-5",  new Fraction( 2, 1),null);
        test(new Fraction( 8, 5), " / 4/-5",  new Fraction( 2,-1),null);
        test(new Fraction( 8,-5), " / 4/-5",  new Fraction( 2, 1),null);
        test(new Fraction(-8,-5), " / 4/-5",  new Fraction( 2,-1),null);
        test(new Fraction(-8, 5), " / -4/-5", new Fraction( 2,-1),null);
        test(new Fraction( 8, 5), " / -4/-5", new Fraction( 2, 1),null);
        test(new Fraction( 8,-5), " / -4/-5", new Fraction( 2,-1),null);
        test(new Fraction(-8,-5), " / -4/-5", new Fraction( 2, 1),null);

        // *
        test(new Fraction(-1, 2), " * 4/5",   new Fraction( 2,-5),null);
        test(new Fraction( 1, 2), " * 4/5",   new Fraction( 2, 5),null);
        test(new Fraction( 1,-2), " * 4/5",   new Fraction( 2,-5),null);
        test(new Fraction(-1,-2), " * 4/5",   new Fraction( 2, 5),null);
        test(new Fraction(-1, 2), " * -4/5",  new Fraction( 2, 5),null);
        test(new Fraction( 1, 2), " * -4/5",  new Fraction( 2,-5),null);
        test(new Fraction( 1,-2), " * -4/5",  new Fraction( 2, 5),null);
        test(new Fraction(-1,-2), " * -4/5",  new Fraction( 2,-5),null);
        test(new Fraction(-1, 2), " * 4/-5",  new Fraction( 2, 5),null);
        test(new Fraction( 1, 2), " * 4/-5",  new Fraction( 2,-5),null);
        test(new Fraction( 1,-2), " * 4/-5",  new Fraction( 2, 5),null);
        test(new Fraction(-1,-2), " * 4/-5",  new Fraction( 2,-5),null);
        test(new Fraction(-1, 2), " * -4/-5", new Fraction( 2,-5),null);
        test(new Fraction( 1, 2), " * -4/-5", new Fraction( 2, 5),null);
        test(new Fraction( 1,-2), " * -4/-5", new Fraction( 2,-5),null);
        test(new Fraction(-1,-2), " * -4/-5", new Fraction( 2, 5),null);

        // ERROR: INVALID_FRACTION
        test(new Fraction(-8,3), "/-8/9", new Fraction(7,9),CalculatorErrors.INVALID_FRACTION);
        test(new Fraction(-8,3), "-8//9", new Fraction(7,9),CalculatorErrors.INVALID_FRACTION);
        test(new Fraction(-8,3), "+-8/9", new Fraction(7,9),CalculatorErrors.INVALID_FRACTION);
        test(new Fraction(-8,3), "*+-8/9", new Fraction(7,9),CalculatorErrors.INVALID_FRACTION);
        test(new Fraction(-8,3), "+/-8/9", new Fraction(7,9),CalculatorErrors.INVALID_FRACTION);
        test(new Fraction(-8,3), "*/+-8/9", new Fraction(7,9),CalculatorErrors.INVALID_FRACTION);
        test(new Fraction(-8,3), "=+-8/9", new Fraction(7,9),CalculatorErrors.INVALID_FRACTION);
        test(new Fraction(-8,3), "clear +-8/9", new Fraction(7,9),CalculatorErrors.INVALID_FRACTION);
        test(new Fraction(-8,3), "abs +-8/9", new Fraction(7,9),CalculatorErrors.INVALID_FRACTION);
        test(new Fraction(-8,3), "c +-8/9", new Fraction(7,9),CalculatorErrors.INVALID_FRACTION);
        test(new Fraction(-8,3), "a +-8/9", new Fraction(7,9),CalculatorErrors.INVALID_FRACTION);
        test(new Fraction(-8,3), "a +-8/9", new Fraction(7,9),CalculatorErrors.INVALID_FRACTION);

        // ERROR: UNKNOWN_OPERATOR
        // Quit only supposed to work when the Calculator is launched, not for testing
        test(new Fraction(-8,3), "quit +-8/9", new Fraction(7,9),CalculatorErrors.UNKNOWN_OPERATOR);
        test(new Fraction(-8,3), "q +-8/9", new Fraction(7,9),CalculatorErrors.UNKNOWN_OPERATOR);

        // ERROR: OPERATOR_OVERRIDE
        test(new Fraction(0,1), "3/4 + + 2", new Fraction(7,9),CalculatorErrors.OPERATOR_OVERRIDE);
        test(new Fraction(0,1), "3/4 + - 2", new Fraction(7,9),CalculatorErrors.OPERATOR_OVERRIDE);
        test(new Fraction(0,1), "3/4 + * 2", new Fraction(7,9),CalculatorErrors.OPERATOR_OVERRIDE);
        test(new Fraction(0,1), "3/4 + / 2", new Fraction(7,9),CalculatorErrors.OPERATOR_OVERRIDE);
        test(new Fraction(0,1), "3/4 - + 2", new Fraction(7,9),CalculatorErrors.OPERATOR_OVERRIDE);
        test(new Fraction(0,1), "3/4 - - 2", new Fraction(7,9),CalculatorErrors.OPERATOR_OVERRIDE);
        test(new Fraction(0,1), "3/4 - * 2", new Fraction(7,9),CalculatorErrors.OPERATOR_OVERRIDE);
        test(new Fraction(0,1), "3/4 - / 2", new Fraction(7,9),CalculatorErrors.OPERATOR_OVERRIDE);
        test(new Fraction(0,1), "3/4 * + 2", new Fraction(7,9),CalculatorErrors.OPERATOR_OVERRIDE);
        test(new Fraction(0,1), "3/4 * - 2", new Fraction(7,9),CalculatorErrors.OPERATOR_OVERRIDE);
        test(new Fraction(0,1), "3/4 * * 2", new Fraction(7,9),CalculatorErrors.OPERATOR_OVERRIDE);
        test(new Fraction(0,1), "3/4 * / 2", new Fraction(7,9),CalculatorErrors.OPERATOR_OVERRIDE);
        test(new Fraction(0,1), "3/4 / + 2", new Fraction(7,9),CalculatorErrors.OPERATOR_OVERRIDE);
        test(new Fraction(0,1), "3/4 / - 2", new Fraction(7,9),CalculatorErrors.OPERATOR_OVERRIDE);
        test(new Fraction(0,1), "3/4 / * 2", new Fraction(7,9),CalculatorErrors.OPERATOR_OVERRIDE);
        test(new Fraction(0,1), "3/4 / / 2", new Fraction(7,9),CalculatorErrors.OPERATOR_OVERRIDE);

        // NO_OPERATOR_DEFINED - Deprecated. MemFraction will be simply reloaded
        test(new Fraction(0,1), "3/4 2", new Fraction(2,1),null);

        // INVALID_OPERATION       ("ERROR: Invalid operation supplied."),
        test(new Fraction(0,1), " *-9", new Fraction(7,9),CalculatorErrors.INVALID_OPERATION);
        test(new Fraction(0,1), " *-7*9", new Fraction(7,9),CalculatorErrors.INVALID_OPERATION);
        test(new Fraction(0,1), " &*-9", new Fraction(7,9),CalculatorErrors.INVALID_OPERATION);
        test(new Fraction(0,1), " --9", new Fraction(7,9),CalculatorErrors.INVALID_OPERATION);
        test(new Fraction(0,1), " *=+-9", new Fraction(7,9),CalculatorErrors.INVALID_OPERATION);
        test(new Fraction(0,1), " d-9", new Fraction(7,9),CalculatorErrors.INVALID_OPERATION);

    }

    /**
     *  Generic test comparison.
     *  Checks if giving initial Fraction and a String test to FractionCalculator.evaluate(),
     *  the expected Fraction is returned from memory as well if any expected errors are thrown.
     */
    static void test(Fraction initF, String test, Fraction expectedResF, CalculatorErrors errorExpected) {

        // Get a new clean instance of the Calculator
        FractionCalculator fc = new FractionCalculator();

        // Evaluate the given expression
        fc.evaluate(initF, test);

        // Retrieve the result and any errors found
        Fraction resF       = fc.getMemFraction();
        CalculatorErrors er = fc.getError();

        // If an error is found, this will be the initial error statement to output.
        String errorString = "[ FAILED ] evaluate(" + initF.toString() + ", '" + test + "')";

        // Analyse results for no expected errors where results differ
        if ( ! expectedResF.equals(resF) && errorExpected == null && er == null) {
            System.out.println(errorString + " = '" + resF.toString() + "', Instead expected: '" + expectedResF.toString() + "'");
        }

        // When no error expected but one was thrown
        if ( errorExpected == null && er != null ) {
            System.out.println(errorString + "\n\tCalculator: '" + er + "'" +
                                             "\n\tTest:       No error expected.");
            // No need to contiue
            return;

        // When an error is expected and none was thrown
         } else if ( errorExpected != null && er == null ) {
            System.out.println(errorString + "\n\tCalculator: OK" +
                                             "\n\tTest:       '" + errorExpected + "'");
            // No need to contiue
            return;

        // When an error is expected and a different error was thrown
         } else if ( errorExpected != null && er != null && !errorExpected.equals(er)) {
            System.out.println(errorString + "\n\tCalculator: '" + er + "'" +
                                             "\n\tTest:       '" + errorExpected + "'");
            // No need to contiue
            return;

        // To be sure we got the correct thing..
         } else if ( errorExpected != null && er != null && errorExpected.equals(er)) {

        // To be sure we got the correct thing..
        } else if ( errorExpected == null && er == null ) {

        // For all cases we have not forseen..
        } else {
            System.out.println(errorString + "\n\tUnknon state!!");

            // No need to contiue
            return;
        }

    }
}
