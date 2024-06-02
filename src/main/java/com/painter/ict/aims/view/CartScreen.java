package com.painter.ict.aims.view;

import com.painter.javafxoop.CartController;
import com.painter.ict.aims.model.cart.Cart;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class CartScreen extends JFrame {

    public CartScreen(Cart cart) {
        super();
        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Cart");
        this.setVisible(true);
        this.setSize(800, 600); // Set the size to 800x600
        this.setLocationRelativeTo(null); // Center the window on the screen

        Platform.runLater(() -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/painter/javafxoop/cart.fxml"));
                CartController controller = new CartController(cart);
                loader.setController(controller);
                Parent root = loader.load();
                fxPanel.setScene(new Scene(root));
            } catch(IOException e) {
                e.printStackTrace();
            }
        });
    }
}
