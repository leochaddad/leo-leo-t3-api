package br.maua.api;

import br.maua.models.MediaType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Class with static methods to fetch data from the API
 */
public class GetAPI {

    /**
     * API URL endpoint
     */
    private static final String ENDPOINT = "https://api.jikan.moe/v3";

    /**
     *
     * @param urlString full path to make the connection
     * @return Connection object from java.net with preset URL and method type "GET"
     */
    public static HttpURLConnection connection(String urlString){

        HttpURLConnection connection = null;
        try {
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
        } catch(IOException e){
            e.printStackTrace();
        }
        return connection;
    }

    /**
     *
     * @param type Type of media to query
     * @param name Media name to query
     * @param limit Number of search results
     * @return Search request result body
     */
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

    /**
     *
     * @param type Type of media to query
     * @param id Media ID
     * @return Media request result body
     */
    public static String getMedia(MediaType type, String id){

        HttpURLConnection connection = connection(
                ENDPOINT+ "/"+type+"/"+id);
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
