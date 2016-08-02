package logic;

/**
 *
 * @author ZozulyaRV
 */
public class CalcOperations {

    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        return a / b;
    }

    public static double extractRoot(double a, double b) {
        return Math.pow(a, (1 / b));
    }

    public static double exponentiate(double a, double b) {
        return Math.pow(a, b);
    }

}
