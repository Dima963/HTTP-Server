package com.company;

import java.net.Socket;

public interface IHttpMethod {

    void execute(httpRequest request, Socket socket);
}
