package br.maua.json;

import br.maua.api.responsemodels.APISearchResponseBody;
import br.maua.models.Anime;
import br.maua.models.Manga;
import br.maua.api.responsemodels.SearchResult;
import com.google.gson.Gson;

import java.util.ArrayList;

public class Parser {

    public static ArrayList<SearchResult> parseSearchResults(String json){
        Gson gson = new Gson();
        APISearchResponseBody searchResponseBody = gson.fromJson(json,APISearchResponseBody.class);
        return searchResponseBody.results;
    }

    public static Anime parseAnime(String json){
        Gson gson = new Gson();
        Anime anime = gson.fromJson(json,Anime.class);
        return anime;
    }

    public static Manga parseManga(String json){
        Gson gson = new Gson();
        Manga manga = gson.fromJson(json,Manga.class);
        return manga;
    }

}
