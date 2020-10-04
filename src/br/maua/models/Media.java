package br.maua.models;


import br.maua.interfaces.IMedia;
import com.google.gson.annotations.SerializedName;

/**
 * Parent class foor media content (either anime or manga)
 *
 */

public class Media implements IMedia {

    @SerializedName("mal_id")
    protected final int id;

    protected final double score;

    protected final String title;

    @SerializedName("synopsis")
    protected final String description;

    @SerializedName("image_url")
    protected final String poster_url;


    /**
     *
     * @param id  Unique identifier for each media object. The same is used in the API and local database
     * @param title Media title
     * @param description Media's description (synopsys)
     * @param score Average of ratings ranging from 0 to 10
     * @param poster_url URL referencing to the media's poster
     */

    public Media(int id, String title, String description, double score, String poster_url){

        this.id = id;
        this.title = title;
        this.description = description;
        this.score = score;
        this.poster_url = poster_url;

    }


    /**
     * Getters
     */

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public double getScore() {
        return score;
    }

    public String getPoster_url() {
        return poster_url;
    }
}
