package com.company.httpServer.com.company.worker;

import com.company.httpServer.com.company.worker.AbstractFactory.AbstractFactory;
import com.company.httpServer.com.company.worker.AbstractFactory.AbstractResponse;

import java.net.Socket;

public class httpGET implements IHttpMethod {

    httpRequest req;
    Socket socket;
    AbstractFactory factory;
    AbstractResponse response;

    public void execute(httpRequest request, Socket socket, AbstractFactory factory) {

        this.req =  request;
        this.socket =  socket;
        this.factory = factory;

        response = factory.createResponse(request, socket);

    }

}

