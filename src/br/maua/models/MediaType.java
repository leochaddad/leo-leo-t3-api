package br.maua.models;

public enum MediaType {
    MANGA("manga"), ANIME("anime");

    String media;
    private MediaType(String media) {
        this.media = media;
    }

    @Override
    public String toString(){
        return media;
    }
}
