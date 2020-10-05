package br.maua.models;


/**
 * Modelos para implementar especificidades de medias tipo ANIME
 *
 */


public class Anime extends Media {

    private final int episodes;

    public Anime(int id, String title, String description, int episodes, double score, String poster_url) {
        super(id, title, description, score, poster_url);

        this.episodes = episodes;
    }


    public int getEpisodes() {
        return episodes;
    }

    @Override
    public String toString() {
        return "\n----- "+ title+" -----"+
                "\n*ID:" + id+
                "\n*Title:" + title+
                "\n*Score=" + score +
                "\n*Episodes:" + episodes +
                "\n*Description:" + description +
                "\n*Poster URL:" + poster_url +
                "------------------------\n";
    }
}
