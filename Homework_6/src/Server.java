
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args)
        {
        try (ServerSocket serverSocket = new ServerSocket(8189);
             Scanner scanner = new Scanner(System.in);)
        {
            System.out.println("Waiting for Connection");
            while (true) {
                Socket s = serverSocket.accept();
                DataInputStream in = new DataInputStream(s.getInputStream());
                DataOutputStream out = new DataOutputStream(s.getOutputStream());

                System.out.println("Client Connected");
                while (true) {
                    String b = in.readUTF();
                    System.out.println("Client sent: " + b);
                    out.writeUTF("server " + scanner.nextLine());
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}



