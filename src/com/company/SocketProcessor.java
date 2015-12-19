package com.company;

import java.io.*;
import java.net.Socket;
import java.nio.Buffer;

/**
 * Created by root on 19.12.15.
 */
public class SocketProcessor implements Runnable {

    Socket socket;

    private PrintWriter pw;
    private BufferedReader br;

    //constructor
    //which accept a socket
    public SocketProcessor(Socket socket) throws Throwable{

        this.socket = socket;
        this.br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.pw =  new PrintWriter(socket.getOutputStream());
    }

    public void run(){
        try {
            String reqS = " ";

            while (br.ready())
                reqS += (char) br.read();


            System.out.println(reqS);

            HttpRequest req = new HttpRequest(reqS);

            HttpResponse res = new HttpResponse(req);

            pw.write(res.respone.toCharArray());
            socket.close();
            pw.close();
            br.close();

        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
