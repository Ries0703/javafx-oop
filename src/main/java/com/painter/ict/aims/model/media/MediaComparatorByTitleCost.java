package com.painter.ict.aims.model.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media firstMedia, Media secondMedia) {
        int titleCompare = firstMedia.getTitle().compareTo(secondMedia.getTitle());

        if (titleCompare == 0) {
            return Double.compare(firstMedia.getCost(), secondMedia.getCost());
        }
        return titleCompare;
    }
}   
