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
        acceptResponse();

    }

    private void acceptResponse() throws Exception {
        while (true){
            Socket socket = server.accept();
            SocketProcessor session =  new SocketProcessor(socket);
            new Thread(session).start();
        }
    }
}
