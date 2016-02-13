package com.company.httpServer.com.company.worker.AbstractFactory;

import com.company.httpServer.com.company.worker.httpRequest;

import java.net.Socket;

/**
 * Created by root on 11.02.16.
 */
public abstract class AbstractFactory {



    //Create factory method
    public abstract AbstractResponse createResponse(httpRequest request, Socket socket);



}
