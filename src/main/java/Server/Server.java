package Server;
import Hibernate.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.*;

public class Server {
    private static final int NUMBER_OF_THREAD = 4;
    private final static String SERVER_ADDRESS = "127.0.0.10";
    private final static int SERVER_PORT = 452;
    private static ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREAD);
    private static ArrayList<WorkerThread> clients = new ArrayList<WorkerThread>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("[SERVER] " + serverSocket.getInetAddress() + " - " + serverSocket.getLocalPort());

            while (true) {

                try {
                    Socket client = serverSocket.accept();
                    System.out.println("Client accepted: " + client);
                    WorkerThread workerThread = new WorkerThread(client);
                    clients.add(workerThread);


                    executorService.execute(workerThread);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            System.err.println("Connection Error: " + e);
        } finally {
            if (serverSocket != null) {
                System.out.println("Close " + serverSocket + " now!");
                serverSocket.close();
            }
        }
    }
}
