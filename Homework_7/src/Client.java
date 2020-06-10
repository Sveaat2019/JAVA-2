import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    static boolean authorized;
    private static String myNick;

    public static void setAuthorized(boolean authorized) {
        Client.authorized = authorized;
    }


    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8189);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("/auth login1 pass1");
            setAuthorized(false);

            Scanner scanner = new Scanner(System.in);
            while (true) {
                String message = scanner.next();
                out.writeUTF(message);
                if (message.equals("/end")) {
                    break;
                }
            }

            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {

                        while (true) {
                            if(in.available()>0) {
                                String strFromServer = in.readUTF();
                                if (strFromServer.startsWith("/authOk")) {
                                    setAuthorized(true);
                                    System.out.println("Authorized on server");
                                    myNick = strFromServer.split("\\s")[1];
                                    break;
                                }
                                System.out.println(strFromServer + "\n");
                            }
                        }
                        while (true) {
                            if (in.available()>0) {
                                String strFromServer = in.readUTF();
                                if (strFromServer.equalsIgnoreCase("/end"))
                                {
                                    break;
                                }
    //                            if (strFromServer.startsWith("/w " + myNick))
                                System.out.println(strFromServer);
                                System.out.println("\n");
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            t.setDaemon(true);
            t.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}