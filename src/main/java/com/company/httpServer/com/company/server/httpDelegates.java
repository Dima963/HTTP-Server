
package com.company.httpServer.com.company.server;

import com.company.httpServer.com.company.worker.AbstractFactory.AbstractResponse;
import com.company.httpServer.com.company.worker.BuildResponse.Response;
import com.company.httpServer.com.company.worker.httpResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class httpDelegates  {

    private String request;
    Socket socket;
    static Response res;
   // static AbstractResponse res;
    httpResponse response;
    PrintWriter pw;

    public httpDelegates(String request, Socket socket)  {

        this.request = request;
        this.socket = socket;

    }

    public httpDelegates(Response res, Socket socket) {

        this.res = res;
        this.socket = socket;

        System.out.println(res);
    }

    public void sendRequest(){

        response = new httpResponse(request, socket);

    }

    public void sendResponse() throws IOException {

        pw = new PrintWriter(socket.getOutputStream());

        pw.write(String.valueOf(this.res));

        pw.close();

        socket.close();

    }

    }
