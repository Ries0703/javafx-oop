package com;


import com.painter.ict.aims.model.media.CompactDisc;
import com.painter.ict.aims.model.media.Media;
import com.painter.ict.aims.model.store.Store;
import com.painter.ict.aims.view.StoreScreen;
import javafx.stage.Stage;

import javax.swing.*;


public class AimsApplication {

    public static void main(String[] args) {

        new Thread(() -> javafx.application.Application.launch(JavaFXInitializer.class)).start();


        Store mockStore = new Store();
        mockStore.addMedia(new Media("DVD1's Title", "Category1", 76.0f) {});
        mockStore.addMedia(new Media("Book2's Title", "Category2", 61.0f) {});
        mockStore.addMedia(new Media("CD3's Title", "Category3", 59.0f) {});
        mockStore.addMedia(new Media("CD4's Title", "Category4", 38.0f) {});
        mockStore.addMedia(new CompactDisc("CD4's Title"));
        mockStore.addMedia(new CompactDisc("CD4's Title"));
        mockStore.addMedia(new CompactDisc("CD4's Title"));
        mockStore.addMedia(new CompactDisc("CD4's Title"));
        mockStore.addMedia(new CompactDisc("CD4's Title"));
        mockStore.addMedia(new CompactDisc("CD4's Title"));


        SwingUtilities.invokeLater(() -> new StoreScreen(mockStore));
    }


    public static class JavaFXInitializer extends javafx.application.Application {
        @Override
        public void start(Stage primaryStage) {

        }
    }
}
