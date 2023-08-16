import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 8080);

        BufferedReader leitor = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter escritor = new PrintWriter(socket.getOutputStream(), true);
        escritor.println("Estou conectando");
        String mensagem = leitor.readLine();
        System.out.println(mensagem);
        socket.close();

    }
}
