package com.company;

public class httpRequest {

    String Filename;

    String RequestMethod;

    public  httpRequest(String request){

        String line[] = request.split("\n");

        System.out.println(line[0]);

        line = line[0].split(" ");

        Filename = line[1];

        RequestMethod = line[0];
    }


}
