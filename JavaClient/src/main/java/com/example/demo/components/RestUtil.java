package com.example.demo.components;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class RestUtil {
    public void getMethod(String url) throws Exception {
        URL restURL = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) restURL.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept","text/xml");
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while((line = br.readLine())!=null){
            System.out.println(line);
        }
        br.close();
    }

    public void postMethod(String url, String query) throws IOException {
        URL restURL = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) restURL.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);
        PrintStream ps = new PrintStream(conn.getOutputStream());
        ps.print(query);
        ps.close();
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while((line = br.readLine()) != null ){
            System.out.println(line);
        }

        br.close();
    }

    public static void main(String[] args) {
        RestUtil restUtil = new RestUtil();
        try {
            restUtil.getMethod("http://localhost:12345/rest/convert/%E5%B0%BC?wadl");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
