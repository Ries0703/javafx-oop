package com.painter.ict.aims.view;

import com.painter.ict.aims.model.media.CompactDisc;
import com.painter.ict.aims.model.store.Store;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    public AddCompactDiscToStoreScreen(Store store) {
        super(store);
        setTitle("Add CD to Store");
        setScene(createScene("CD"));
    }

    @Override
    protected void addItem() {
        String title = titleField.getText();
        String category = categoryField.getText();
        Integer cost = Integer.parseInt(costField.getText());

        CompactDisc cd = new CompactDisc(title, category, cost);
        store.addMedia(cd);

        // Clear fields after adding
        titleField.clear();
        categoryField.clear();
        costField.clear();
    }
}
