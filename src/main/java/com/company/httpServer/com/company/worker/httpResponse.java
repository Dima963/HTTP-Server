package com.company.httpServer.com.company.worker;


import java.net.Socket;

public class httpResponse {

    String request;
    Socket socket;
    httpMethodContext httpMethod =  new httpMethodContext();

    public httpResponse(String request, Socket socket){

        this.request = request;
        this.socket = socket;

        httpRequest req  = new httpRequest(request);

        if((req.RequestMethod).equals("GET"))
        {
            httpMethod.setHttpMethod(new httpGET());

            httpMethod.executeIHttpMethod(req, socket);

        } else if(req.RequestMethod == "POST"){

            httpMethod.setHttpMethod(new httpPOST());

        } else if (req.RequestMethod == "DELETE"){

            httpMethod.setHttpMethod(new httpDELETE());
        }

    }


}
