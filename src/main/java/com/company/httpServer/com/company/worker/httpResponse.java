package com.company.httpServer.com.company.worker;


import com.company.httpServer.com.company.worker.AbstractFactory.AbstractFactory;
import com.company.httpServer.com.company.worker.AbstractFactory.FactoryGET;

import java.net.Socket;

public class httpResponse {

    String request;
    Socket socket;
    httpMethodContext httpMethod =  new httpMethodContext();
    AbstractFactory factory;

    public httpResponse(String request, Socket socket){

        this.request = request;
        this.socket = socket;

        httpRequest req  = new httpRequest(request);

        if((req.RequestMethod).equals("GET"))
        {
            factory =  new FactoryGET();

            httpMethod.setHttpMethod(new httpGET());

            httpMethod.executeIHttpMethod(req, socket, factory);

        } else if(req.RequestMethod == "POST"){

            httpMethod.setHttpMethod(new httpPOST());

        } else if (req.RequestMethod == "DELETE"){

            httpMethod.setHttpMethod(new httpDELETE());
        }

    }


}
