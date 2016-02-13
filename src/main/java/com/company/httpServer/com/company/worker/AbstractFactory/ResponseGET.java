package com.company.httpServer.com.company.worker.AbstractFactory;

import com.company.httpServer.com.company.server.httpDelegates;
import com.company.httpServer.com.company.worker.BuildResponse.Director;
import com.company.httpServer.com.company.worker.BuildResponse.Response;
import com.company.httpServer.com.company.worker.BuildResponse.ResponseBuilder;
import com.company.httpServer.com.company.worker.BuildResponse.httpResponseBuilder;
import com.company.httpServer.com.company.worker.httpRequest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.Socket;

/**
 * Created by root on 11.02.16.
 */
public class ResponseGET extends AbstractResponse {

    httpRequest req;
    Socket socket;
    String root = "/home/user/Документи/rootServer";
    String response;
    String responseHead;
    httpDelegates delegates;

    ResponseGET(httpRequest req,Socket socket ){

        this.req = req;
        this.socket =  socket;

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

            System.out.println("------------------------------------------------");

            System.out.println(res);

            delegates = new httpDelegates(res, socket);


            fis.close();

        } catch (FileNotFoundException e) {

            response = response.replace("200", "404");

        } catch (Exception e) {

            response = response.replace("200", "500");

        }


    }

}
