package com.painter.ict.aims.view;

import com.painter.ict.aims.model.cart.Cart;
import com.painter.ict.aims.model.media.Media;
import com.painter.ict.aims.model.media.Playable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MediaStore extends JPanel {

    public MediaStore(Media media, Cart cart) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel cost = new JLabel(media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton addToCartButton = new JButton("Add to Cart");
        JButton playButton = new JButton("Play");

        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cart.addMedia(media);
                JOptionPane.showMessageDialog(null, media.getTitle() + " added to cart.");
            }
        });

        if (media instanceof Playable) {
            playButton.addActionListener(e -> {
                JDialog playDialog = new JDialog();
                playDialog.setTitle(media.getClass().getSimpleName());
                playDialog.setSize(300, 200);
                playDialog.add(new JLabel("Playing " + media.getTitle(), SwingConstants.CENTER));
                playDialog.setVisible(true);
                playDialog.setLocationRelativeTo(null);
            });
            container.add(playButton);
        }

        container.add(addToCartButton);

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
