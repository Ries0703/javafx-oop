package com.painter.ict.aims.controller;

import com.painter.ict.aims.model.media.Media;
import com.painter.ict.aims.model.store.Store;

import java.util.ArrayList;

public class StoreController {
    private final Store store;

    public StoreController(Store store) {
        this.store = store;
    }

    public ArrayList<ArrayList<Media>> getMediaRows(int itemsPerRow) {
        ArrayList<ArrayList<Media>> rows = new ArrayList<>();
        ArrayList<Media> mediaInStore = store.getItemsInStore();

        for (int i = 0; i < mediaInStore.size(); i++) {
            if (i % itemsPerRow == 0) {
                rows.add(new ArrayList<>());
            }
            rows.get(rows.size() - 1).add(mediaInStore.get(i));
        }

        return rows;
    }
}
