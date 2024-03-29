import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable
{
    private Socket client;
    private BufferedReader in;
    private PrintWriter out;
    private ArrayList<ClientHandler> clients;

    public ClientHandler (Socket clientSocket, ArrayList<ClientHandler> clients) throws IOException
    {
        this.client = clientSocket;
        this.clients = clients;
        in = new BufferedReader(new InputStreamReader((client.getInputStream())));
        out = new PrintWriter(client.getOutputStream(), true);
    }

    @Override
    public void run()
    {

    }
}
