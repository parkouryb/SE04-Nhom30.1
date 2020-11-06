package Server;

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
        System.out.println("Processing: " + this.client.getInetAddress() + " - " + this.client.getLocalPort());
        try {
            while (true) {
                String command = bufferedReader.readLine();
                System.out.println("[SERVER][COMMAND] " + command);
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

        System.out.println("Complete processing: " + this.client.getInetAddress() + " - " + this.client.getLocalPort());
    }
}
