package lab7.part2;

public class FactorialInputException extends Exception {
    
    public FactorialInputException(int n) {
        super("Bad input to factorial: " + n);
    }
}
