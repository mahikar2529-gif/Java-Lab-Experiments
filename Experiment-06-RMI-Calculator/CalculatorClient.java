import java.rmi.Naming;

/** Looks up the remote object and invokes its methods. */
public class CalculatorClient {
    public static void main(String[] args) {
        try {
            CalculatorInterface calc =
                (CalculatorInterface) Naming.lookup("rmi://localhost:1099/CalculatorService");
            int a = 20, b = 5;
            System.out.println("Remote call: multiply(" + a + ", " + b + ") = " + calc.multiply(a, b));
            System.out.println("Remote call: add(" + a + ", " + b + ")      = " + calc.add(a, b));
            System.out.println("Remote call: subtract(" + a + ", " + b + ") = " + calc.subtract(a, b));
        } catch (Exception e) {
            System.out.println("Client error: " + e);
        }
    }
}
