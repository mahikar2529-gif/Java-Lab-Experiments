import java.rmi.Remote;
import java.rmi.RemoteException;

/** Remote interface: every remote method must throw RemoteException. */
public interface CalculatorInterface extends Remote {
    int multiply(int a, int b) throws RemoteException;
    int add(int a, int b) throws RemoteException;
    int subtract(int a, int b) throws RemoteException;
}
