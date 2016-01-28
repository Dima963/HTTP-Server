package com.company.httpServer.com.company.worker.BuildResponse;

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
