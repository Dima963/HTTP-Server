package com.company.httpServer.com.company.worker;

import com.company.httpServer.com.company.worker.AbstractFactory.AbstractFactory;

import java.net.Socket;

public  class httpMethodContext {

    private IHttpMethod _httpMethod;

    Socket socket;
    AbstractFactory factory;

    public void setHttpMethod(IHttpMethod _httpMethod) {
        this._httpMethod = _httpMethod;
    }

    public void executeIHttpMethod(httpRequest request, Socket socket, AbstractFactory factory) {

         this.socket = socket;
        this.factory =  factory;

        _httpMethod.execute(request,socket, factory);

    }
}
