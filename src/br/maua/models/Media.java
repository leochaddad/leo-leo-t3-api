package br.maua.models;


import com.google.gson.annotations.SerializedName;

/**
 * Classe parente para implementacao de modelos de media (anime, manga, livros etc) para o DB
 *
 */

public class Media {

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
     * @param id  id identificadora do objeto de midia no MAL
     * @param title titulo do objeto de midia
     * @param description descricao do objeto de midia
     * @param score valor medio dos votos (em escala 0-10)
     * @param poster_url endereco do poster representativo da midia
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
