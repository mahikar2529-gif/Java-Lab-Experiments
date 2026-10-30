import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/** Starts the RMI registry and binds the calculator object. */
public class CalculatorServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            Naming.rebind("rmi://localhost:1099/CalculatorService", new CalculatorImpl());
            System.out.println("Calculator RMI Server is ready...");
        } catch (Exception e) {
            System.out.println("Server error: " + e);
        }
    }
}
