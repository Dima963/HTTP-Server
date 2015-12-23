package com.company;

/**
 * Created by root on 19.12.15.
 */
class HttpRequest {


    String filename;
    public HttpRequest(String request ){
        String line[] = request.split("\n");

        //this line basically split first line using space" " and then select the 2nd item

        System.out.println(line[0]);
        line = line[0].split(" ");
        filename = line[1];


    }
}
