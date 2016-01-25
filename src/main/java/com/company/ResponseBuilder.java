package com.company;

/**
 * Created by root on 23.01.16.
 */
public abstract class ResponseBuilder {

    protected  Response response;

    public  Response getResponse(){
        return response;
    }



    public void createNewResponseProduct(){
        response = new Response();
    }

    public abstract void buildHead();
    public abstract void buildBody();
}
