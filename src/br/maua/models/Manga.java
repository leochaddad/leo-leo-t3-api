package br.maua.models;

public class Manga extends Media {

    private final String type;
    private final int chapters;
    private final int volumes;


    Manga(int id, String title, String description,String type, int chapters, int volumes, double score, String poster_url){

        super(id, title, description, score, poster_url);

        this.type = type;
        this.chapters = chapters;
        this.volumes = volumes;

    };

    @Override
    public String toString() {
        return "Manga{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", chapters=" + chapters +
                ", volumes=" + volumes +
                ", score=" + score +
                ", description='" + description + '\'' +
                ", poster_url='" + poster_url + '\'' +
                '}';
    }
}
