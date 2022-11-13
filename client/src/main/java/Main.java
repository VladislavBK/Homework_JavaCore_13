import java.io.*;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 7001;

        try (Socket clientSocket = new Socket(host, port)) {
            while (true) {
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                out.println("Vladislav");

                String response = in.readLine();
                System.out.println(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
