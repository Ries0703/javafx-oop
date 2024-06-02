package com.painter.ict.aims.view;

import com.painter.ict.aims.model.media.Book;
import com.painter.ict.aims.model.store.Store;
import com.painter.ict.aims.view.AddItemToStoreScreen;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    public AddBookToStoreScreen(Store store) {
        super(store);
        setTitle("Add Book to Store");
        setScene(createScene("Book"));
    }

    @Override
    protected void addItem() {
        String title = titleField.getText();
        String category = categoryField.getText();
        Integer cost = Integer.parseInt(costField.getText());

        Book book = new Book(title, category, cost);
        store.addMedia(book);

        // Clear fields after adding
        titleField.clear();
        categoryField.clear();
        costField.clear();

    }
}
