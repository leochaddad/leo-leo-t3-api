package br.maua.models;

public class Manga extends MediaType {

    private final String type;
    private final int chapters;
    private final int volumes;


    Manga(int id, String title, String description, String type, int chapters, int volumes, double score, String poster_url){

        super(id, title, description, score, poster_url);

        this.type = type;
        this.chapters = chapters;
        this.volumes = volumes;

    };

}
