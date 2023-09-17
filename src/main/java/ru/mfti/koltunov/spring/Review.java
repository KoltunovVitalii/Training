package ru.mfti.koltunov.spring;

public class Review {
    private String text;
    private int rating;

    public Review(String text, int rating) {
        this.text = text;
        this.rating = rating;
    }

    public String getText() {
        return text;
    }

    public int getRating() {
        return rating;
    }
}
