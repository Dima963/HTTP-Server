package com.company;

public class Response {

    private String head;
    private String body;

    public String getHead(){
        return head;
    }

    public void setHead(String head){
        this.head= head;
    }

    public String getBody(){
        return body;
    }

    public void setBody(String body){
        this.body = body;
    }

    public String toString(){
        return head + body;
    }
}
