import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Server Started");
        int port = 7001;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                PrintStream out = new PrintStream(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                System.out.printf("New connection accepted. Port: %d%n", clientSocket.getPort());
                final String name = in.readLine();
                out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));
            }
        }
    }
}
