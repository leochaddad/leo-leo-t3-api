package br.maua.models;

/**
 * Media type, either ANIME or MANGA
 */
public enum MediaType {
    MANGA("manga"), ANIME("anime");

    /**
     * Media type in the expected API format
     */
    String media;
    private MediaType(String media) {
        this.media = media;
    }

    @Override
    public String toString(){
        return media;
    }
}
