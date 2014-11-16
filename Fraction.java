/**
 * Created by keith for the second coursework assignment.
 */
public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int num, int denom) {
        if (denom == 0) {
            System.out.println("Invalid fraction with denominator 0");
            // this should use exceptions
            return;
        }
        int gcd = myGcd(num, denom);
        setNumerator(num / gcd);
        setDenominator(denom / gcd);
    }

    @Override
    public String toString() {
        if ( getDenominator() == 1 ) {
            return "" + getNumerator();
        }
        else {
            return "" + getNumerator() + '/' + getDenominator();
        }
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int num) {
        numerator = num;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int num) {
        denominator = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fraction fraction = (Fraction) o;

        if (getDenominator() != fraction.getDenominator()) return false;
        if (getNumerator() != fraction.getNumerator()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = getNumerator();
        result = 31 * result + getDenominator();
        return result;
    }

    public Fraction multiply(Fraction other) {

        int num   = getNumerator()   * other.getNumerator();
        int denom = getDenominator() * other.getDenominator();
        return new Fraction(num, denom);
    }

    /**
    *  Add other Fraction to this Fraction.
    */
    public Fraction add(Fraction other) {

        int otherNum   = other.getNumerator();
        int otherDenom = other.getDenominator();

        // Same denominator -> add numerators only
        if ( getNumerator() == otherDenom ) {
            return new Fraction( (otherNum + getNumerator()), getDenominator());
        }
        // Different denominators -> apply common demominators
        else {
            return new Fraction(
                ( (otherNum * getDenominator()) + (getNumerator() * otherDenom) ),
                (otherDenom * getDenominator())
            );
        }
    }

    /**
    *  subtract -> same as add with other.negate()
    */
    public Fraction subtract(Fraction other) {

        return add(other.negate());
    }

    /**
    *  (this.n/this.d)/(other.n/other.d) -> (this.n*other.d)/(this.d*other.n)
    */
    public Fraction divide(Fraction other) {

        if ( other.getDenominator() == 0 ) {
            System.out.println("Invalid fraction with denominator 0");
            // this should use exceptions
            return null;
        }
        else {
            return new Fraction(
                getNumerator()   * other.getDenominator(),
                getDenominator() * other.getNumerator()
            );
        }
    }

    /**
    *  Change sign of the numerator
    */
    public Fraction negate() {
        return new Fraction( - getNumerator(), getDenominator() );
    }

    /**
    *  Returns the non-negative value
    */
    public Fraction absValue() {
        int num = getNumerator();
        int denom = getDenominator();

        if ( num < 0 ) {
            num = - num;
        }
        if ( denom < 0 ) {
            denom = - denom;
        }

        return new Fraction( num, denom );
    }

    /**
    *  Returns the normalised Fracion
    */
    public Fraction normalise() {
        // Find the biggest common divisor int
        int gcd = myGcd(getNumerator(), getDenominator());
        return new Fraction (getDenominator() / gcd, getNumerator() / gcd);
    }

    private int myGcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}
