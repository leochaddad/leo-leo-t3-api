package br.maua.api;

import br.maua.json.Parser;
import br.maua.models.MediaType;

public class TestGetAPI {
    /**
     *Tests and demos on fetching data from the API and deserializing.
     */
    public static void main(String[] args) {
        String json = GetAPI.search(MediaType.ANIME, "naruto", 3);
        System.out.println(Parser.parseSearchResults(json));

        json = GetAPI.getMedia(MediaType.ANIME, 16);
        System.out.println(Parser.parseAnime(json));

        json = GetAPI.getMedia(MediaType.MANGA, 16);
        System.out.println(Parser.parseManga(json));
    }
}

