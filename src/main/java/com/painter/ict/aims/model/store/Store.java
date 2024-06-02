package com.painter.ict.aims.model.store;

import com.painter.ict.aims.model.media.Media;
import lombok.Getter;

import java.util.ArrayList;

@Getter
public class Store {
    public static final int MAX_NUMBERS_STORE = 1000;

    ArrayList<Media> itemsInStore = new ArrayList<>();

    public String addMedia(Media newDisc) {
        if (this.itemsInStore.size() < MAX_NUMBERS_STORE) {
            this.itemsInStore.add(newDisc);
            System.out.println("THe item has been successfully added");
            return "THe item has been successfully added";
        } else {
            return "The Store is full";
        }
    }

    public String removeMedia(Media DVD) {
        if (this.itemsInStore.contains(DVD)) {
            this.itemsInStore.remove(DVD);
            return "The item is successfully removed";
        } else {
            return "THis item is not in Store";
        }
    }


    public void getStore() {
        System.out.println("**********************STORE***********************");
        System.out.println("Items:");
        for (int i = 0; i < itemsInStore.size(); i++) {
            System.out.println((i + 1) + ". " + itemsInStore.get(i).toString());
        }
        System.out.println("***************************************************");
    }

    public Media searchByTitle(String title) {
        for (Media media : this.itemsInStore) {
            if (media.getTitle().compareTo(title) == 0) {
                return media;
            }
        }
        System.out.println("Cannot found media");
        return null;
    }

}
