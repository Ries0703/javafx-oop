package com.painter.ict.aims.model.media;

import java.util.Comparator;

public class MediaComparatorByID implements Comparator<Media> {
    @Override
    public int compare(Media firstMedia, Media secondMedia) {
        return Integer.compare(firstMedia.getId(), secondMedia.getId());
    }
}