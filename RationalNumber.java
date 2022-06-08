package lab7.part1;

public class RationalNumber {
    
    /**
     * A rational number is of the form p/q, where
     * p and q are integers and q != 0.
     */
    private int p;
    private int q;

    public RationalNumber(int p, int q) {
        super();

        if (q == 0) {
            throw new ArithmeticException("Denominator cannot be 0!");
        }

        this.p = p;
        this.q = q;
    }


    public static RationalNumber convertToAbsoluteValue(RationalNumber r) {
        r.p = Math.abs(r.p);
        r.q = Math.abs(r.q);
        return r;
    }

    // Helper method to reduce rational number to its lowest form
    private static void reduceToLowestForm(RationalNumber r) {

        // If both numberator and denominator are negative, make them positive
        if (r.p < 0 && r.q < 0) {
            convertToAbsoluteValue(r);
        }

        // Work on absolute value, add sign later.
        boolean isNegative = false;
        if (r.p < 0 && r.q > 0 || r.q < 0 && r.p >= 0) {
            convertToAbsoluteValue(r);
            isNegative = true;
        }

        // Find GCD of numerator and denominator
        int gcd = 1;
        for (int i = 1; i <= r.p && i <= r.q; ++i) {
            if (r.p % i == 0 && r.q % i == 0) {
                gcd = i;
            }
        }

        // Divide numerator and denominator by GCD
        r.p /= gcd;
        r.q /= gcd;

        if (r.p == 0) {
            r.q = 1;
        }

        // Convert rational number back to its signed form
        if (isNegative == true) {
            r.p = -r.p;
        }
    }


    public static RationalNumber addition(RationalNumber r1, RationalNumber r2) {

        int denominator = r1.q * r2.q;
        int numerator = r1.p * r2.q + r2.p * r1.q;
        RationalNumber result = new RationalNumber(numerator, denominator);

        reduceToLowestForm(result);
        return result;
    }

    public static RationalNumber subtraction(RationalNumber r1, RationalNumber r2) {

        // Make r2 negative and perform addition
        r2.p = -r2.p;
        return addition(r1, r2);
    }

    public static RationalNumber multiplication(RationalNumber r1, RationalNumber r2) {

        int numerator = r1.p * r2.p;
        int denominator = r1.q * r2.q;
        RationalNumber result = new RationalNumber(numerator, denominator);

        reduceToLowestForm(result);
        return result;
    }

    public static RationalNumber division(RationalNumber r1, RationalNumber r2) {

        // Check if r2 is 0
        if (r2.p == 0) {
            throw new ArithmeticException("Cannot divide by 0!");
        }

        // Invert r2 and perform multiplication
        int temp = r2.p;
        r2.p = r2.q;
        r2.q = temp;

        return multiplication(r1, r2);
    }

    public float getFloatingPoint() {
        return (float) this.p / (float) this.q;
    }

    /**
     * @return -1 when r1 < r2, 
     *          0 when r1 == r2, 
     *         +1 when r1 > r2
     */
    public static int compare(RationalNumber r1, RationalNumber r2) {

        if (r1.getFloatingPoint() < r2.getFloatingPoint()) {
            return -1;
        }
        
        if (r1.getFloatingPoint() > r2.getFloatingPoint()) {
            return 1;
        }
        
        return 0;
    }

    @Override
    public String toString() {
        
        reduceToLowestForm(this);
        return this.p + "/" + this.q;
    }
}
