import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Requests implements Runnable {

    private Socket client;

    Requests(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        System.out.println("Cliente " + client.getInetAddress().getHostAddress() + " conectado");
        try (BufferedReader leitor = new BufferedReader(new InputStreamReader(client.getInputStream()))) {
            PrintWriter escritor = new PrintWriter(client.getOutputStream(), true);
            String mensagem = leitor.readLine();
            System.out.println("Mensagem do cliente " + mensagem);
            escritor.println("A mensagem: " + mensagem + ", foi recebida");
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
