import java.io.*;
import java.net.*;

/**
 * Experiment 4 (Server): TCP server using ServerSocket and Socket.
 * Echoes each message back in upper case until the client sends "bye".
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        int port = 5000;
        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server started. Waiting for client on port " + port + "...");
            try (Socket s = server.accept();
                 BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
                 PrintWriter out = new PrintWriter(s.getOutputStream(), true)) {
                System.out.println("Client connected: " + s.getInetAddress());
                String line;
                while ((line = in.readLine()) != null) {
                    System.out.println("Client says: " + line);
                    if (line.equalsIgnoreCase("bye")) {
                        out.println("Goodbye!");
                        break;
                    }
                    out.println(line.toUpperCase());
                }
            }
            System.out.println("Connection closed.");
        }
    }
}
