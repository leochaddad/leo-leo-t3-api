package br.maua.models;

public class Manga extends Media {

    private final String type;
    private final int chapters;
    private final int volumes;


    public Manga(int id, String title, String description, String type, int chapters, int volumes, double score, String poster_url){

        super(id, title, description, score, poster_url);

        this.type = type;
        this.chapters = chapters;
        this.volumes = volumes;

    };

    public String getType() {
        return type;
    }

    public int getChapters() {
        return chapters;
    }

    public int getVolumes() {
        return volumes;
    }

    @Override
    public String toString() {
        return "\n----- "+ title+" -----"+
                "\n*ID: " + id+
                "\n*Score: " + score +
                "\n*Description: " + description +
                "\n*Type: " + type +
                "\nChapters: " + chapters +
                "\nVolumes: " + volumes +
                "\n*Poster URL: " + poster_url + '\n'+
                "------------------------\n";

    }
}

