package lab7.part2;

public class Factorial {
    
    static int factorial(int n) throws FactorialInputException, ArithmeticException {

        int result = 1;
        
        if (n < 0) {
            throw new FactorialInputException(n);
        }

        if (n == 0) {
            return result;
        }

        for (int i = 2; i <= n; ++i) {
            result = Math.multiplyExact(result, i);
        }

        return result;
    }
}
