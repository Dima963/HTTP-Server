package com.company.httpServer.com.company.worker;

import java.net.Socket;

public  class httpMethodContext {

    private IHttpMethod _httpMethod;

    Socket socket;

    public void setHttpMethod(IHttpMethod _httpMethod) {
        this._httpMethod = _httpMethod;
    }

    public void executeIHttpMethod(httpRequest request, Socket socket) {

         this.socket = socket;

        _httpMethod.execute(request,socket);

    }
}
