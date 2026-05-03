package task2;

import java.io.*;
import java.net.*;

public class BlockingEchoClient {
    public static void main(String[] args) throws IOException {
        String host = "localhost";
        int port = 8081;
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        try (
                Socket socket = new Socket(host, port);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            System.out.print("You: ");
            String message = console.readLine();
            out.println(message);
            out.flush();

            String response = in.readLine();
            System.out.println("Server: " + response);

            String confirmation;
            do {
                System.out.print("You: ");
                confirmation = console.readLine();
                out.println(confirmation);
                out.flush();
            } while (!"Hi".equalsIgnoreCase(confirmation));
        }
    }
}
