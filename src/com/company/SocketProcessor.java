package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by root on 19.12.15.
 */
public class SocketProcessor implements Runnable {

    Socket socket;

    PrintWriter pw;
    BufferedReader br;

    //constructor
    //which accept a socket
    public SocketProcessor(Socket socket) throws  Exception{

        this.socket = socket;
        br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        pw =  new PrintWriter(socket.getOutputStream());
    }

    public void run(){
        try {
            String reqS = "";

            while (br.ready() || reqS.length() == 0 ) reqS += (char) br.read();

            System.out.println(reqS); //print the question from client

            HttpRequest req = new HttpRequest(reqS); //question

            HttpResponse res = new HttpResponse(req); //answer

            pw.write(res.respone.toCharArray());

            pw.close();
            br.close();
            socket.close();

        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
