package task1;

import java.io.*;
import java.net.*;

public class HttpClient {
    public static void main(String[] args) throws IOException {
        String host = "localhost";
        int port = 8080;

        try (
                Socket socket = new Socket(host, port);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            String httpRequest = "GET /index.html HTTP/1.1\r\n" +
                    "Host: " + host + "\r\n" +
                    "Connection: close\r\n" +
                    "\r\n";
            out.print(httpRequest);
            out.flush();

            String responseLine;
            while ((responseLine = in.readLine()) != null) {
                System.out.println(responseLine);
            }
        }
    }
}
