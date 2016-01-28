package com.company.httpServer.com.company.worker;



import java.net.Socket;

public interface IHttpMethod {

    void execute(httpRequest request, Socket socket);
}
