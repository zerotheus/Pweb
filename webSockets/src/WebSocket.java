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
            System.out.println("Cliente " + client.getInetAddress().getHostAddress() + " conectado");
            BufferedReader leitor = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter escritor = new PrintWriter(client.getOutputStream(), true);
            String mensagem = leitor.readLine();
            System.out.println("Mensagem do cliente " + mensagem);
            escritor.println("A mensagem: " + mensagem + ", foi recebida");
            client.close();
        }
    }
}
