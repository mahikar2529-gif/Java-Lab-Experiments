import java.io.*;
import java.net.*;

/**
 * Experiment 4 (Client): TCP client using Socket.
 * Type messages; type "bye" to end the session.
 */
public class TCPClient {
    public static void main(String[] args) throws IOException {
        try (Socket s = new Socket("localhost", 5000);
             BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
             PrintWriter out = new PrintWriter(s.getOutputStream(), true);
             BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Connected to server.");
            String msg;
            while (true) {
                System.out.print("Enter message: ");
                msg = console.readLine();
                if (msg == null) break;
                out.println(msg);
                System.out.println("Server replies: " + in.readLine());
                if (msg.equalsIgnoreCase("bye")) break;
            }
        }
        System.out.println("Disconnected.");
    }
}
