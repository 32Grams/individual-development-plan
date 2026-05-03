import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        int port = 8081;
        ServerSocket serverSocket = new ServerSocket(port);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            try (
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
            ) {
                String greeting = in.readLine();
                if ("Hello".equals(greeting)) {
                    out.println("Hi");
                    out.flush();
                    String confirmation = in.readLine();
                    if (!"Hi".equals(confirmation)) {
                        break;
                    }
                }
            } finally {
                clientSocket.close();
            }
        }
    }
}
