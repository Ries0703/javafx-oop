package com.painter.ict.aims.view;

import com.painter.ict.aims.model.media.DigitalVideoDisc;
import com.painter.ict.aims.model.store.Store;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store);
        setTitle("Add DVD to Store");
        setScene(createScene("DVD"));
    }

    @Override
    protected void addItem() {
        String title = titleField.getText();
        String category = categoryField.getText();
        int cost = Integer.parseInt(costField.getText());

        DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, cost);
        store.addMedia(dvd);

        // Clear fields after adding
        titleField.clear();
        categoryField.clear();
        costField.clear();
    }
}
