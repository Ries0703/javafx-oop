package com.painter.javafxoop;

import com.painter.ict.aims.model.cart.Cart;
import com.painter.ict.aims.model.media.Media;
import com.painter.ict.aims.model.media.Playable;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;

public class CartController {

    private final Cart cart;

    private final FloatProperty totalCost = new SimpleFloatProperty();

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private Label totalLabel;

    public CartController(Cart cart) {
        this.cart = cart;
        updateTotalCost();
    }

    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                updateButtonBar(newValue);
            }
        });
        ObservableList<Media> observableList = FXCollections.observableArrayList(this.cart.getItemsOrdered());
        tblMedia.setItems(observableList);
        totalLabel.textProperty().bind(totalCost.asString());
    }

    private void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        btnPlay.setVisible(media instanceof Playable);
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
        System.out.println(cart.getItemsOrdered().size());
        ObservableList<Media> observableList = FXCollections.observableArrayList(this.cart.getItemsOrdered());
        tblMedia.setItems(observableList);
    }

    // Other code

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media instanceof Playable) {
            Alert playDialog = new Alert(Alert.AlertType.INFORMATION);
            playDialog.setTitle(media.getClass().getSimpleName());
            playDialog.setHeaderText(null);
            playDialog.setContentText("Playing " + media.getTitle());
            playDialog.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            playDialog.showAndWait();
        }
    }

    public FloatProperty totalCostProperty() {
        return totalCost;
    }

    private void updateTotalCost() {
        totalCost.set(cart.totalCost());
    }
}
