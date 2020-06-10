import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MyServer {
    private final int PORT = 8189;
    private List<ClientHandler> clients;

    private AuthService authService;

    public AuthService getAuthService()
    {
        return authService;
    }

    public MyServer() {
        try (ServerSocket server = new ServerSocket(PORT)) {
            authService = new AuthService();
            authService.start();
            clients = new ArrayList<>();
            while (true) {
                System.out.println("Server awaits clients");
                Socket socket = server.accept();
                System.out.println("Client connected");
                new ClientHandler(this, socket);//добавляем в список клиентов
            }
        } catch (IOException ex) {
            System.out.println("Server error");
        } finally {//закрываем сервис авторизации
            if(authService!=null) {
                authService.stop();
            }
        }
    }


    public synchronized void unsubscribe(ClientHandler clientHandler) {
        clients.remove(clientHandler);
    }

    public synchronized void subscribe(ClientHandler clientHandler) {//клиентов в список добавляет
        clients.add(clientHandler);
    }

    public synchronized void broadcast(String s) {//проходит по списку и посылает сообщение всем подписанным клиентам чата
        for(ClientHandler client: clients) {
            client.sendMsg(s);
        }
    }

    public synchronized boolean isNickLogged(String nick) {
        for(ClientHandler client: clients) {
            if (client.getName().equals(nick)) {//такой ник используется
                return true;
            }
        }
        return false;
    }

    public void sendMsgToClient(ClientHandler clientHandler, String nick, String msg)
    {
        for(ClientHandler client: clients)
        {
            if(client.getName().equals(nick)) client.sendMsg(msg);
        }
    }
}