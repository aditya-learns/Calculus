package Differenciation;

public class SymbolicDerivativeCalculator {

    public static void main(String[] args) {
        System.out.println(computeSymbolicDerivative("sin(-x)","x"));
    }
    // Method to compute the symbolic derivative of an inputted function
    public static String computeSymbolicDerivative(String function, String variable) {
        return differentiate(function, variable);
    }

    // Helper method to differentiate the function
    private static String differentiate(String function, String variable) {
        // Trivial case: the input function is a variable
        if (function.equals(variable)) {
            return "1";
        }

        // Trivial case: the input function is a constant
        if (isNumeric(function)) {
            return "0";
        }

        // Trivial case: the input function is a power of a variable
        if (function.startsWith(variable + "^")) {
            String[] parts = function.split("\\^");
            int exponent = Integer.parseInt(parts[1]);
            int newExponent = exponent - 1;
            return exponent + "*" + variable + "^" + newExponent;
        }

        // Trivial case: the input function is a trigonometric function of a variable
        if (function.startsWith("sin(" + variable + ")")) {
            return "cos(" + variable + ")";
        }
        if (function.startsWith("cos(" + variable + ")")) {
            return "-sin(" + variable + ")";
        }
        if (function.startsWith("tan(" + variable + ")")) {
            return "sec(" + variable + ")^2";
        }

        // Trivial case: the input function is a logarithmic function of a variable
        if (function.startsWith("ln(" + variable + ")")) {
            return "1/" + variable;
        }

        // Non-trivial case: the input function is a composite function
        return null;
    }

    // Helper method to check if a string represents a numeric value
    private static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
