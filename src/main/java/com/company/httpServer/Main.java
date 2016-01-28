package com.company.httpServer;

import com.company.httpServer.com.company.server.httpServer;

import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    private static final int host = 4014;
    ServerSocket serverSocket;

    public static void main(String[] args) throws Throwable{
        new Main().startServer();
    }

    private void startServer() throws Exception {
        System.out.println("Connect to the host port");
        serverSocket = new ServerSocket(host);
        connectServer();
    }

    private void connectServer() throws Exception {
        while (true){
            Socket socket = serverSocket.accept();
            System.out.println("Connect client to the httpServer");
            httpServer serverProcess  =  new httpServer(socket);
            new Thread(serverProcess).start();





        }
    }
}
