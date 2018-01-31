package server;

import Client.ChatHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

    public static void main(String[] args) {

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8082);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Получили запррос от " + socket.getInetAddress());
                ChatHandler chatHandler = new ChatHandler(socket);
                chatHandler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null) {   // проверили что он НЕ = null
                    serverSocket.close();   // закрыли serverSocket
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
