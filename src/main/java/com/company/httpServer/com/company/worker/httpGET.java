package com.company.httpServer.com.company.worker;

import com.company.httpServer.com.company.server.httpDelegates;
import com.company.httpServer.com.company.worker.BuildResponse.Director;
import com.company.httpServer.com.company.worker.BuildResponse.Response;
import com.company.httpServer.com.company.worker.BuildResponse.ResponseBuilder;
import com.company.httpServer.com.company.worker.BuildResponse.httpResponseBuilder;

import java.io.*;
import java.net.Socket;

public class httpGET implements IHttpMethod {

    httpRequest req;
    String response;
    String responseHead;
    Socket socket;
    String root = "/home/user/Документи/rootServer";

    public void execute(httpRequest request, Socket socket) {

        this.req =  request;
        this.socket =  socket;
        req =  request;

        File f = new File(root+req.Filename);

        try {

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


            httpDelegates delegates = new httpDelegates(res, socket);


            fis.close();

        } catch (FileNotFoundException e) {

            response = response.replace("200", "404");

        } catch (Exception e) {

            response = response.replace("200", "500");

        }

    }
}
