package com.painter.ict.aims.model.media;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CompactDisc extends Disc implements Playable {
    private final List<Track> tracks = new ArrayList<>();
    private String artist;


    public CompactDisc(String title, String category, float cost, String director, String artist) {
        super(title, category, director, 0, cost);
        this.artist = artist;
    }

    public CompactDisc(String title) {
        super(title);
    }

    public CompactDisc(String title, String category, Integer cost) {
        super(title, category, cost);
    }

    public String addTrack(String title, int length) {
        for (Track track : this.tracks) {
            if (track.getTitle().equals(title)) {
                return "Track has been already added in list";
            }
        }
        Track newTrack = new Track(title, length);
        this.tracks.add(newTrack);
        this.setLength(this.getLength() + length);
        return "Track has been added";
    }

    public String removeTrack(String trackName) {
        for (int i = 0; i < tracks.size(); i++) {
            if (this.tracks.get(i).getTitle().equals(trackName)) {
                this.setLength(this.getLength() - this.tracks.get(i).getLength());
                tracks.remove(i);
                return "Track has been removed";
            }
        }
        return "Cant found track";
    }

    public String toString() {
        return "ID: " + this.getId() + " CD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getArtist() + " - " + this.getLength() + " : " + this.getCost();
    }

    @Override
    public void play() {
        System.out.println("*********************PLAYING*********************");
        System.out.println("Now playing: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
        for (Track track : this.tracks) {
            track.play();
        }
        System.out.println("*************************************************");
    }
}


