package com.company;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by root on 19.12.15.
 */
public class HttpResponse {
    HttpRequest req;

    public String respone;

    //root path of the server
    String root = "/home/user/Документи/rootServer";


    public HttpResponse(HttpRequest request) {
        req =  request;
        File f = new File(root+req.filename);

        try {

            respone =  "HTTP/1.1 200 \r\n";//Version of http

            respone += "Server: Our java Server/1.0.0 \r\n";

            respone += "Connection: close \r\n";
            respone += "Content-Type: text/html \r\n";
            respone += "Content-Length: " +f.length()+" \r\n";
            respone += "\r\n";

            FileInputStream fis = new FileInputStream(f);

            int s;
            while(!((s = fis.read()) == -1)){
                respone +=(char) s;
            }

            fis.close();
        } catch (FileNotFoundException e) {
            respone = respone.replace("200", "404");
        } catch (Exception e) {
            respone = respone.replace("200", "500");
        }

    }
}