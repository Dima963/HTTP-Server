package com.company.httpServer.com.company.worker;

import com.company.httpServer.com.company.worker.AbstractFactory.AbstractFactory;

import java.net.Socket;

public class httpPOST implements IHttpMethod {

    httpRequest request;
    Socket socket;
    AbstractFactory factory;

    public void execute(httpRequest request, Socket socket,  AbstractFactory factory) {

        this.request = request;
        this.socket = socket;
        this.factory =  factory;

    }
}
