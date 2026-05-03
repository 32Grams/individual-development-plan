package task1;

import java.io.*;
import java.net.*;

public class HttpServer {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        ServerSocket serverSocket = new ServerSocket(port);

        while (true) {
            Socket clientSocket = serverSocket.accept();

            try (
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
            ) {
                String line;
                while ((line = in.readLine()) != null && !line.isEmpty()) {
                }

                String body = "Hello from server!";
                String httpResponse = "HTTP/1.1 200 OK\r\n" +
                        "Content-Type: text/plain\r\n" +
                        "Content-Length: " + body.length() + "\r\n" +
                        "Connection: close\r\n" +
                        "\r\n" +
                        body;
                out.print(httpResponse);
                out.flush();
            } finally {
                clientSocket.close();
            }
        }
    }
}
