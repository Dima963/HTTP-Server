package com.company;

/**
 * Created by root on 23.01.16.
 */
public class httpResponseBuilder extends ResponseBuilder {

    String Body;
    String Head;

    public httpResponseBuilder(String head, String body){

        this.Head =  head;
        this.Body = body;

    }

    @Override
    public void buildHead() {

        response.setHead(Head);

    }

    @Override
    public void buildBody() {

        response.setBody(Body);

    }
}
