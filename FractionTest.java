/**
 * Created by keith for the second coursework assignment.
 */
public class FractionTest {
    public static void main(String[] args) {

        // test divide by zero - should print an error and exit
        new Fraction(1, 0);
        // test multiply
        Fraction x = new Fraction(1,2);
        Fraction y = new Fraction(3,5);
        Fraction r = new Fraction(3,10);
        if (!r.equals(x.multiply(y))) System.out.println("Multiply failed");
        // test equals
        test(new Fraction(1, 2),  new Fraction(1, 2), "error test 1");
        test(new Fraction(1, 2),  new Fraction(3, 6), "error test 2");
        test(new Fraction(-1, 2), new Fraction(1, -2),"error test 3");
        test(new Fraction(-1, -2),new Fraction(1, 2), "error test 4");
        test(new Fraction(4, -8), new Fraction(1, -2),"error test 5");

        // test add
        testAdd("Addition 1", new Fraction( 3, 10), new Fraction( 1, 2), new Fraction( 8, 10));
        testAdd("Addition 2", new Fraction(-3, 10), new Fraction( 1, 2), new Fraction( 1, 5));
        testAdd("Addition 3", new Fraction(-3, 10), new Fraction( 1,-2), new Fraction(-8, 10));

        // test subtraction
        testSubtraction("Substraction 1", new Fraction( 3, 10), new Fraction( 1, 2), new Fraction(-1, 5));
        testSubtraction("Substraction 2", new Fraction(-3, 10), new Fraction( 1, 2), new Fraction(-4, 5));
        testSubtraction("Substraction 3", new Fraction( 3, 10), new Fraction(-1, 2), new Fraction( 4, 5));

        // test division
        testDivision("Division 1", new Fraction( 3, 10), new Fraction( 1, 2), new Fraction( 3, 5));
        // test division by zero - should print an error
        testDivision("Division 2", new Fraction( 3, 10), new Fraction( 0, 2), new Fraction( 0, 0));

        // test absValue
        testAbsValue("Abs 1", new Fraction( 3, 10), new Fraction(3,10));
        testAbsValue("Abs 2", new Fraction(-3, 10), new Fraction(3,10));
        testAbsValue("Abs 3", new Fraction(-3,-10), new Fraction(3,10));
        testAbsValue("Abs 4", new Fraction(-3,-10), new Fraction(3,10));

        // test negate
        testNegate("Negate 1", new Fraction( 3, 10), new Fraction(-3, 10));
        testNegate("Negate 2", new Fraction( 3,-10), new Fraction( 3, 10));
        testNegate("Negate 3", new Fraction(-3, 10), new Fraction( 3, 10));
        testNegate("Negate 4", new Fraction(-3,-10), new Fraction( 3,-10));

    }

    static void testAdd(String test, Fraction x, Fraction y, Fraction r) {
        if (!r.equals(x.add(y))) testFailed(test, "addition", "+", x, x.add(y), r);
	}

    static void testSubtraction(String test, Fraction x, Fraction y, Fraction r) {
        if (!r.equals(x.subtract(y))) testFailed(test, "subtraction", "-", x, x.subtract(y), r);
	}

    static void testDivision(String test, Fraction x, Fraction y, Fraction r) {
        if (!r.equals(x.divide(y))) testFailed(test, "division", "/", x, x.divide(y), r);
	}

    static void testAbsValue(String test, Fraction x, Fraction r) {
        if (!r.equals(x.absValue())) testFailed(test, "absValue", "abs", x, x.absValue(), r);
	}

    static void testNegate(String test, Fraction x, Fraction r) {
        if (!r.equals(x.negate())) testFailed(test, "negate", "negate", x, x.negate(), r);
	}

    static void testFailed(String test, String method, String op, Fraction x, Fraction f, Fraction r) {
		System.out.println("TEST " + test + ": " + method + " failed! " +
            op + "(" + x.toString() + ") = " +
            f.toString() + ", expected: " +
            r.toString()
        );
    }

    static void testFailed(int test, String method, String op, Fraction x, Fraction y, Fraction f, Fraction r) {
		System.out.println("TEST " + test + ": " + method + " failed! " +
            x.toString() + " "+ op + " " +
            y.toString() + " = " +
            f.toString() + ", expected: " +
            r.toString()
        );
    }

    static void test(Fraction f1, Fraction f2, String msg){
        if (! f1.equals(f2))
        System.out.println(msg);
    }
}
