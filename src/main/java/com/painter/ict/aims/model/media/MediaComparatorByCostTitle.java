package com.painter.ict.aims.model.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    @Override
    public int compare(Media firstMedia, Media secondMedia) {
        int costCompare = Double.compare(firstMedia.getCost(), secondMedia.getCost());

        if (costCompare == 0) {
            return firstMedia.getTitle().compareTo(secondMedia.getTitle());
        }
        return costCompare;
    }
}
