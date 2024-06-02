package com.painter.ict.aims.view;

import com.painter.ict.aims.controller.StoreController;
import com.painter.ict.aims.model.cart.Cart;
import com.painter.ict.aims.model.media.CompactDisc;
import com.painter.ict.aims.model.media.Media;
import com.painter.ict.aims.model.store.Store;
import javafx.application.Platform;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StoreScreen extends JFrame {
    private final StoreController controller;
    private final Cart cart;
    private final Store store;

    public StoreScreen(Store store) {
        this.controller = new StoreController(store);
        this.cart = new Cart();
        this.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);
        setVisible(true);
        setTitle("Store");
        setSize(1024, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");
        JMenu smUpdateStore = new JMenu("Update Store");

        JMenuItem addBookItem = new JMenuItem("Add Book");
        addBookItem.addActionListener(e -> Platform.runLater(() -> new AddBookToStoreScreen(store).show()));

        JMenuItem addCDItem = new JMenuItem("Add CD");
        addCDItem.addActionListener(e -> Platform.runLater(() -> new AddCompactDiscToStoreScreen(store).show()));

        JMenuItem addDVDItem = new JMenuItem("Add DVD");
        addDVDItem.addActionListener(e -> Platform.runLater(() -> new AddDigitalVideoDiscToStoreScreen(store).show()));

        JMenuItem viewCart = new JMenuItem("View Cart");
        viewCart.addActionListener(e -> Platform.runLater(() -> new CartScreen(cart).setVisible(true)));



        smUpdateStore.add(addBookItem);
        smUpdateStore.add(addCDItem);
        smUpdateStore.add(addDVDItem);

        menu.add(smUpdateStore);
        menu.add(new JMenuItem("View Store"));
        menu.add(viewCart);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }



    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        // Create a container for the buttons to ensure they align horizontally
        JPanel buttonContainer = new JPanel();
        buttonContainer.setLayout(new BoxLayout(buttonContainer, BoxLayout.X_AXIS));

        // Create a Refresh button with the same properties as the View Cart button
        JButton refreshButton = new JButton("Refresh");
        refreshButton.setPreferredSize(new Dimension(100, 50));
        refreshButton.setMaximumSize(new Dimension(100, 50));
        refreshButton.addActionListener(e -> refreshView());

        JButton cartButton = new JButton("View cart");
        cartButton.setPreferredSize(new Dimension(100, 50));
        cartButton.setMaximumSize(new Dimension(100, 50));
        cartButton.addActionListener(e -> Platform.runLater(() -> new CartScreen(cart).setVisible(true)));

        buttonContainer.add(refreshButton);
        buttonContainer.add(Box.createRigidArea(new Dimension(10, 10))); // Add space between buttons
        buttonContainer.add(cartButton);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(buttonContainer);
        header.add(Box.createHorizontalGlue());
        header.add(title);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }




    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Add some padding
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        ArrayList<ArrayList<Media>> mediaRows = controller.getMediaRows(3);
        for (ArrayList<Media> row : mediaRows) {
            for (Media media : row) {
                MediaStore cell = new MediaStore(media, cart);
                center.add(cell, gbc);
                gbc.gridx++;
            }
            gbc.gridx = 0;
            gbc.gridy++;
        }

        return center;
    }

    public void refreshView() {
        // Clear the existing components
        getContentPane().removeAll();

        // Rebuild the view components
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(createNorth(), BorderLayout.NORTH);
        getContentPane().add(createCenter(), BorderLayout.CENTER);

        // Repaint the frame
        revalidate();
        repaint();
    }


}
