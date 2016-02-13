package com.company.httpServer.com.company.worker;



import com.company.httpServer.com.company.worker.AbstractFactory.AbstractFactory;

import java.net.Socket;

public interface IHttpMethod {

    void execute(httpRequest request, Socket socket, AbstractFactory factory);
}
