package com.painter.ict.aims.model.media;

import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;
import java.util.Objects;

@Setter
@Getter
public abstract class Media {

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
    private static int nbMedia = 0;
    private int id;
    private String title;
    private String category;
    private float cost;

    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
        nbMedia++;
    }

    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.id = nbMedia;
        nbMedia++;
    }

    public Media(String title, String category) {
        this.title = title;
        this.category = category;
        this.id = nbMedia;
        nbMedia++;
    }

    public Media(String title) {
        this.title = title;
        this.id = nbMedia;
        nbMedia++;
    }

    public Media(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public boolean isMatch(String title) {
        return this.getTitle().equalsIgnoreCase(title);
    }

    public boolean isMatch(int id) {
        return this.getId() == id;
    }

    public boolean equals(Media otherMedia) {
        return Objects.equals(this.title, otherMedia.getTitle());
    }
    public void play() {}
}
