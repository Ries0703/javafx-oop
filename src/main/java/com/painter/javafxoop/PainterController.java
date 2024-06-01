package com.painter.javafxoop;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import javafx.event.ActionEvent;


public class PainterController {

    @FXML
    private Pane drawingAreaPane = new Pane();

    @FXML
    public void clearButtonPressed(ActionEvent actionEvent) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    public void drawingAreaMouseDragged(MouseEvent mouseEvent) {
        Circle circle = new Circle(mouseEvent.getX(), mouseEvent.getY(), 4, Color.BLACK);
        drawingAreaPane.getChildren().add(circle);
    }
}