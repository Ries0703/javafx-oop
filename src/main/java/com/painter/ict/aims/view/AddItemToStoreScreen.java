package com.painter.ict.aims.view;

import com.painter.ict.aims.model.store.Store;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public abstract class AddItemToStoreScreen extends Stage {
    protected Store store;

    protected TextField titleField;
    protected TextField categoryField;
    protected TextField costField;

    public AddItemToStoreScreen(Store store) {
        this.store = store;
        this.titleField = new TextField();
        this.categoryField = new TextField();
        this.costField = new TextField();
    }

    protected Scene createScene(String itemType) {
        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        gridPane.add(new Label(itemType + " Title:"), 0, 0);
        gridPane.add(titleField, 1, 0);

        gridPane.add(new Label("Category:"), 0, 1);
        gridPane.add(categoryField, 1, 1);

        gridPane.add(new Label("Cost:"), 0, 2);
        gridPane.add(costField, 1, 2);

        Button addButton = new Button("Add " + itemType);
        addButton.setOnAction(e -> addItem());

        gridPane.add(addButton, 1, 3);

        return new Scene(gridPane, 400, 300);
    }

    protected abstract void addItem();
}
