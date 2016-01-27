package com.company;

import com.company.Response;
import com.company.ResponseBuilder;

public class Director {

    private ResponseBuilder responseBuilder;

    public void setResponseBuilder(ResponseBuilder responseBuilder){
        this.responseBuilder = responseBuilder;
    }

    public Response getResponse(){

        return responseBuilder.getResponse();

    }

    public void constructResponse(){

        responseBuilder.createNewResponseProduct();
        responseBuilder.buildHead();
        responseBuilder.buildBody();


    }

}
