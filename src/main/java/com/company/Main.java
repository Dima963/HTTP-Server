package com.company;

import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    private static final int host = 4014;
    ServerSocket server;

    public static void main(String[] args) throws Throwable{
        new Main().startServer();
    }

    public void startServer() throws Exception {
        System.out.println("Server is start");
        server = new ServerSocket(host); // Connect to the host port
        System.out.println("Connect to the host port");
        acceptResponse();

    }

    private void acceptResponse() throws Exception {
        while (true){
            Socket socket = server.accept();
            System.out.println("Connect");
            SocketProcess session =  new SocketProcess(socket);
            System.out.println("Start new Thread");
            new Thread(session).start();
        }
    }
}
