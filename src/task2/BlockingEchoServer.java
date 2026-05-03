package task2;

import java.io.*;
import java.net.*;

public class BlockingEchoServer {
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

                if ("Hello".equalsIgnoreCase(greeting)) {
                    out.println("Hi");
                    out.flush();

                    while (!"Hi".equalsIgnoreCase(in.readLine())) {
                    }
                } else {
                    while (!"Hi".equalsIgnoreCase(in.readLine())) {
                    }
                }
            } finally {
                clientSocket.close();
            }
        }
    }
}
