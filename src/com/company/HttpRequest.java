package com.company;

/**
 * Created by root on 19.12.15.
 */
public class HttpRequest {


    String filename;
   public HttpRequest(String request ){
       String line[] = request.split("\n");

       //this line basically split first line using space" " and then select the 2nd item

       filename = line[0].split(" ")[1];


    }
}
