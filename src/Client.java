import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        String host = "localhost";
        int port = 8081;

        try (
                Socket socket = new Socket(host, port);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            out.println("Hello");
            out.flush();
            String response = in.readLine();
            System.out.println(response);
            out.println(response);
            out.flush();
        }
    }
}
