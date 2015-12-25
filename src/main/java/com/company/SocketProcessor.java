package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketProcessor implements Runnable {

    Socket socket;
    PrintWriter pw;
    BufferedReader br;
    httpMethodContext httpMethod =  new httpMethodContext();

    //constructor
    //which accept a socket
    public SocketProcessor(Socket socket) throws  Exception{

        this.socket = socket;
        br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

    }

    public void run(){

        String reqS = "";
        try {
            while(br.ready()){
                reqS +=(char)br.read();
            }
            System.out.println(reqS);  //print the question from client

            httpRequest req  = new httpRequest(reqS);

            if((req.RequestMethod).equals("GET"))
            {
                httpMethod.setHttpMethod(new httpGET());

                httpMethod.executeIHttpMethod(req, socket);




            } else if(req.RequestMethod == "POST"){

                httpMethod.setHttpMethod(new httpPOST());



            } else if (req.RequestMethod == "DELETE"){

                httpMethod.setHttpMethod(new httpDELETE());
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
/*
HttpRequestGET req = new HttpRequestGET(reqS); //question

HttpResponseGET res = new HttpResponseGET(req); //answer


System.out.printf(String.valueOf(res.response.toCharArray()));

        pw.write(res.response.toCharArray());

        pw.close();
        br.close();
        socket.close();

        }catch (Exception e) {
        e.printStackTrace();


        */