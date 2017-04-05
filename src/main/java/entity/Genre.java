package entity;

public enum Genre {
    ACTION("ACTION"), ADVENTURE("ADVENTURE"), COMEDY("COMEDY"), CRIME("CRIME"), DRAMA("DRAMA"),
    HORROR("HORROR"), WESTERNS("WESTERNS"), WAR("WAR");

    String genre;

    Genre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }
}
