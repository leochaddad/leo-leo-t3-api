package br.maua.json;

import br.maua.api.responsemodels.APISearchResponseBody;
import br.maua.models.Anime;
import br.maua.models.Manga;
import br.maua.api.responsemodels.SearchResult;
import com.google.gson.Gson;

import java.util.ArrayList;

public class Parser {

    /**
     *Parses the response of an API search into an array list of objects
     * @param json API search result to be parsed
     * @return ArrayList of results
     */
    public static ArrayList<SearchResult> parseSearchResults(String json){
        Gson gson = new Gson();
        APISearchResponseBody searchResponseBody = gson.fromJson(json,APISearchResponseBody.class);
        return searchResponseBody.results;
    }

    /**
     *
     * @param json Parses the response of an API media query into a Manga type object
     * @return Parsed anime
     */
    public static Anime parseAnime(String json){
        Gson gson = new Gson();
        Anime anime = gson.fromJson(json,Anime.class);
        return anime;
    }

    /**
     *Parses the response of an API media query into an Anime type object
     * @param json API media result to be parsed as Manga media type
     * @return Parsed anime
     */
    public static Manga parseManga(String json){
        Gson gson = new Gson();
        Manga manga = gson.fromJson(json,Manga.class);
        return manga;
    }

}
