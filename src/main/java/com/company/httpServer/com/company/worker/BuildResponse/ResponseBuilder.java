package com.company.httpServer.com.company.worker.BuildResponse;

import com.company.httpServer.com.company.worker.BuildResponse.Response;

/**
 * Created by root on 23.01.16.
 */
public abstract class ResponseBuilder {

    protected Response response;

    public void createNewResponseProduct(){
        response = new Response();
    }

    public  Response getResponse(){

        return response;
    }



    public abstract void buildHead();

    public abstract void buildBody();
}
