package Server;

import Interactive.DatabaseInteractive;
import org.hibernate.dialect.Database;

import java.io.*;
import java.net.Socket;

public class WorkerThread implements Runnable {
    private Socket client;
    private BufferedReader bufferedReader = null;
    private PrintWriter printWriter = null;

    public WorkerThread(Socket client) throws IOException {
        this.client = client;
        this.bufferedReader = new BufferedReader(new InputStreamReader(this.client.getInputStream()));
        this.printWriter = new PrintWriter(this.client.getOutputStream(), true);
    }

    @Override
    public void run() {
        System.out.println("Processing: " + this.client.getInetAddress() + ":" + this.client.getLocalPort());
        try {
            while (true) {
                System.out.print("[SERVER][WAITING]: ");
                String command = bufferedReader.readLine();
                System.out.println("[SERVER][COMMAND][RECEIVE][SUCCESS]");
                if (command.startsWith("$101")) {
                    System.out.println("Process $101");
                    if (DatabaseInteractive.Register(command)) {
                        System.out.println("Success");
                    }
                }


            }
        } catch (IOException e) {
            System.err.println("Request Processing Error: " + e);
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            printWriter.close();
        }

        System.out.println("Complete processing: " + this.client.getInetAddress() + ":" + this.client.getLocalPort());
    }

    public void sayToAll(String message) {
        for (WorkerThread aClient: Server.clients) {
            aClient.printWriter.println(message);
        }
    }
}
