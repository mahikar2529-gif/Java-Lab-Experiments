import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/** Implementation of the remote calculator. */
public class CalculatorImpl extends UnicastRemoteObject implements CalculatorInterface {

    public CalculatorImpl() throws RemoteException {
        super();
    }

    public int multiply(int a, int b) throws RemoteException { return a * b; }
    public int add(int a, int b) throws RemoteException { return a + b; }
    public int subtract(int a, int b) throws RemoteException { return a - b; }
}
