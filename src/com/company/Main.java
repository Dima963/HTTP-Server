package com.company;

import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws Throwable{

        ServerSocket server = new ServerSocket(4014); // Connect to the host port


        while (true){
            Socket socket = server.accept();
            SocketProcessor session =  new SocketProcessor(socket);
            new Thread(session).start();
        }

    }
}
