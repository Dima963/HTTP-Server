package com.company;

import com.company.Response;

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
