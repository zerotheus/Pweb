import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class WebSocket {

    private static final int serverport = 8080;

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        ServerSocket server = new ServerSocket(serverport);
        System.out.println("Servidor na porta: " + server.getLocalPort());
        while (true) {
            Socket client = server.accept();
            Requests requests = new Requests(client);
            requests.run();
        }
    }
}
