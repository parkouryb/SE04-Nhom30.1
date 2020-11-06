package Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientTesting {

        public final static String SERVER_IP = "127.0.0.1";
        public final static int SERVER_PORT = 452;
        public static Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException, InterruptedException {
            Socket socket = null;
            try {
                socket = new Socket(SERVER_IP, SERVER_PORT); // Connect to server
                System.out.println("Connected: " + socket);
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                PrintWriter printWriter = new PrintWriter(outputStream, true);
                while (true) {
                    System.out.println("[COMMAND] ");
                    String command = scanner.nextLine();
                    System.out.println("[TAKE] " + command);
                    printWriter.println(command);
                }
//                for (int i = '0'; i <= '9'; i++) {
//                    os.write(i); // Send each number to the server
//                    System.out.println("Sending " + i + " to server...");
//                    int ch = is.read(); // Waiting for results from server
//                    System.out.print("Receive " +  ch + "\n"); // Display the results received from the server
//                    Thread.sleep(1000);
//                }
            } catch (IOException ie) {
                System.out.println("Can't connect to server");
            } finally {
                if (socket != null) {
                    socket.close();
                }
            }
        }

}
