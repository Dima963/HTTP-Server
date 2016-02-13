package com.company.httpServer.com.company.worker.AbstractFactory;

import com.company.httpServer.com.company.worker.httpRequest;

import java.net.Socket;

/**
 * Created by root on 11.02.16.
 */
public class FactoryPOST extends AbstractFactory {
    @Override
    public AbstractResponse createResponse(httpRequest request, Socket socket) {
        return new ResponsePOST();
    }
}
