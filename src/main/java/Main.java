import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        int port = 8087;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                    out.println("Как тебя зовут?");
                    final String name = in.readLine();

                    out.println("Сколько тебе лет?");
                    final String age = in.readLine();

                    if (Integer.valueOf(age) < 18) {
                        out.println("Ограничение по возрасту. Покиньте сайт");
                    } else {
                        out.println("К нам на сервер проскользнул " + name + ". Ему " + age + " лет ^_^");
                    }
                }
            }
        }
    }
}