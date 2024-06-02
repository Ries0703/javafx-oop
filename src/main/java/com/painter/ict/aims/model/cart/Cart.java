package com.painter.ict.aims.model.cart;



import com.painter.ict.aims.model.media.Media;
import com.painter.ict.aims.model.media.MediaComparatorByCostTitle;
import com.painter.ict.aims.model.media.MediaComparatorByID;
import com.painter.ict.aims.model.media.MediaComparatorByTitleCost;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Comparator;

@Getter
@Setter
public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private final ArrayList<Media> itemsOrdered = new ArrayList<>();

    public String addMedia(Media newMedia) {
        if (this.itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            return "The cart has been full";
        }
        if (this.itemsOrdered.contains(newMedia)) {
            return "Item " + newMedia.getTitle() + " has been already added";
        }
        this.itemsOrdered.add(newMedia);
        return "Item " + newMedia.getTitle() + " has been successfully added";
    }

    public String removeMedia(Media removedMedia) {
        if (this.itemsOrdered.contains(removedMedia)) {
            this.itemsOrdered.remove(removedMedia);
            return "item" + removedMedia.getTitle() + " has been successfully removed";
        }
        return "Item " + removedMedia.getTitle() + " not exist in cart";
    }

    public String removeMedia(String title) {
        for (int i = 0; i < itemsOrdered.size(); i++) {
            if (itemsOrdered.get(i).getTitle().compareTo(title) == 0) {
                itemsOrdered.remove(i);
                return "item" + title + " has been successfully removed";
            }
        }
        return "Item " + title + " not exist in cart";
    }

    public float totalCost() {
        float res = 0;
        for (Media media : this.itemsOrdered) {
            res += media.getCost();
        }
        return res;
    }

    public void addMedia(ArrayList<Media> mediaList) {
        for (Media media : mediaList) {
            addMedia(media);
        }
    }

    public void getCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered items:");
        for (int i = 0; i < this.itemsOrdered.size(); i++) {
            System.out.println((i + 1) + ". " + this.itemsOrdered.get(i).toString());
        }
        System.out.println("Total cost: " + this.totalCost());
        System.out.println("***************************************************");
    }

    public Media searchByID(int id) {
        for (Media media : this.itemsOrdered) {
            if (media.getId() == id) {
                return media;
            }
        }
        return null;
    }

    public Media searchByTitle(String title) {
        for (Media media : this.itemsOrdered) {
            if (media.isMatch(title)) {
                return media;
            }
        }
        return null;
    }

    public void placeOrder() {
        this.itemsOrdered.clear();
    }

    public void sortByCostTitle() {
        Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
        this.itemsOrdered.sort(COMPARE_BY_COST_TITLE);
    }

    public void sortByTitleCost() {
        Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
        this.itemsOrdered.sort(COMPARE_BY_TITLE_COST);
    }

    public void sortByID() {
        Comparator<Media> COMPARE_BY_ID = new MediaComparatorByID();
        this.itemsOrdered.sort(COMPARE_BY_ID);
    }
}

