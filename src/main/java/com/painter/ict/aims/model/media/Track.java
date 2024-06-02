package com.painter.ict.aims.model.media;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Track implements Playable {
    private final String title;
    private final int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public void play() {
        System.out.println("Playing Track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }

    public boolean equals(Track otherTrack) {
        return Objects.equals(this.title, otherTrack.getTitle()) && this.length == otherTrack.getLength();
    }

}
