import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class serverThread implements Runnable {
    private Socket clientSocket;

    public serverThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Messaggio ricevuto dal client " + clientSocket.getRemoteSocketAddress() + ": " + inputLine);
                // qui viene gestita la richiesta del client e inviata la risposta
                String outputLine = "Risposta del server: " + inputLine;
                out.println(outputLine);
            }
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
