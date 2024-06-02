package com.painter.ict.aims.model.media;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Disc extends Media {
    private int length;
    private String director;

    public Disc(String title, String category, String director, int length, float cost) {
        super(title, category, cost);
        this.length = length;
        this.director = director;
    }

    public Disc(String title, String category, String director, float cost) {
        super(title, category, cost);
        this.director = director;
    }

    public Disc(String title) {
        super(title);
    }

    public Disc(String title, String category, Integer cost) {
        super(title, category, cost);
    }
}
