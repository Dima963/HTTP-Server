package com.company.httpServer.com.company.worker;

public class httpRequest {

    public String Filename;

   public String RequestMethod;

    public  httpRequest(String request){

        String line[] = request.split("\n");

        System.out.println(line[0]);

        line = line[0].split(" ");

        RequestMethod = line[0];

        Filename = line[1];




    }





}
