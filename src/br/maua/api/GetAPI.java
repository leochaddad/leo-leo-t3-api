package br.maua.api;

import br.maua.models.MediaType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

public class GetAPI {

    private static final String ENDPOINT = "https://api.jikan.moe/v3";

    public static HttpURLConnection connection(String urlString){

        HttpURLConnection connection = null;
        try{
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
        }catch(IOException e){
            e.printStackTrace();
        }
        return connection;
    }

    public static String search(MediaType type, String name, Integer limit){
        HttpURLConnection connection = connection(
                ENDPOINT+ "/search/"+type+"?q="+name+"&limit="+limit);
        StringBuilder content = new StringBuilder();
        Integer responsecode;

        try {
            int statusCode = connection.getResponseCode();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream())
            );
            in.lines().forEach(content::append);
            in.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }

        return content.toString();

    }

    public static String getMedia(MediaType type, String mal_id){

        HttpURLConnection connection = connection(
                ENDPOINT+ "/"+type+"/"+mal_id);
        StringBuilder content = new StringBuilder();
        Integer responsecode;

        try {
            int statusCode = connection.getResponseCode();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream())
            );
            in.lines().forEach(content::append);
            in.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }

        return content.toString();

    }


}
