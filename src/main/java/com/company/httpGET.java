package com.company;

import java.io.*;
import java.net.Socket;

public class httpGET implements IHttpMethod {

    httpRequest req;
    String response;
    String responseHead;
    PrintWriter pw;
    Socket socket;
    String root = "/home/user/Документи/rootServer";

    public void execute(httpRequest request, Socket socket) {

        this.req =  request;
        this.socket =  socket;
        req =  request;

        File f = new File(root+req.Filename);

        try {
            pw = new PrintWriter(socket.getOutputStream());

            response =  "HTTP/1.1 200 \r\n";
            response += "Server: Our java Server/1.0.0 \r\n";
            response += "Connection: close \r\n";
            response += "Content-Type: text/html \r\n";
            response += "Content-Length: " +f.length()+" \r\n";
            response += "\r\n";

            FileInputStream fis = new FileInputStream(f);

            int s;
            while(!((s = fis.read()) == -1)){
                responseHead +=(char) s;
            }

            Director director = new Director();
            ResponseBuilder responseBuilder = new httpResponseBuilder(response, responseHead);

            director.setResponseBuilder(responseBuilder);
            director.constructResponse();

            Response res = director.getResponse();

        

            pw.write(String.valueOf(res));

            pw.close();

            fis.close();

            socket.close();

        } catch (FileNotFoundException e) {

            response = response.replace("200", "404");

        } catch (Exception e) {

            response = response.replace("200", "500");

        }

    }
}
