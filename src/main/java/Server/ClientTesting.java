package Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientTesting {

        public final static String SERVER_IP = "127.0.0.10";
        public final static int SERVER_PORT = 452;
        public static Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException, InterruptedException {
            Socket socket = null;
            try {
                socket = new Socket(SERVER_IP, SERVER_PORT); // Connect to server
                System.out.println("Connected: " + socket);
                OutputStream outputStream = socket.getOutputStream();
                PrintWriter printWriter = new PrintWriter(outputStream, true);
                while (true) {
                    System.out.print("[CLIENT][COMMAND][SEND] ");
                    String command = scanner.nextLine();
                    printWriter.println(command);

                }
            } catch (IOException ie) {
                System.out.println("Can't connect to server");
            } finally {
                if (socket != null) {
                    socket.close();
                }
            }
        }

}
