package com.company.httpServer.com.company.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class httpServer implements Runnable {

    Socket socket;
    BufferedReader br;

    public httpServer(Socket socket) throws IOException {

        this.socket =  socket;
        br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

    }

    public void run() {

        String reqS ="";

        try {
                while(br.ready()){
                    reqS +=(char)br.read();}

                System.out.println("print the question from client");
                System.out.println(reqS);

                httpDelegates delegate = new httpDelegates(reqS, socket);
                delegate.sendRequest();
                delegate.sendResponse();


            } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}

