package br.maua.api.responsemodels;

import com.google.gson.annotations.SerializedName;

public class SearchResult {

    @SerializedName("mal_id")
    Integer id;
    String title;

    @Override
    public String toString() {
        return "{" +
                "mal_id='" + id + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
