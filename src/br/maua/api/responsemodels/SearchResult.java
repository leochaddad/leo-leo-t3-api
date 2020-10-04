package br.maua.api.responsemodels;

import br.maua.interfaces.IMedia;
import com.google.gson.annotations.SerializedName;

public class SearchResult implements IMedia {

    @SerializedName("mal_id")
    int id;
    String title;

    @Override
    public String toString() {
        return "{" +
                "mal_id='" + id + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public int getId() {
        return id;
    }
}
