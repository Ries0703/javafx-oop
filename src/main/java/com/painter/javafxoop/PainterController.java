package com.painter.javafxoop;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.event.ActionEvent;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private RadioButton penRadioButton;

    @FXML
    private RadioButton eraserRadioButton;

    private ToggleGroup toolsToggleGroup;

    @FXML
    public void initialize() {
        toolsToggleGroup = new ToggleGroup();
        penRadioButton.setToggleGroup(toolsToggleGroup);
        eraserRadioButton.setToggleGroup(toolsToggleGroup);
        penRadioButton.setSelected(true);
    }

    @FXML
    public void clearButtonPressed(ActionEvent actionEvent) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    public void drawingAreaMouseDragged(MouseEvent mouseEvent) {
        Color color = penRadioButton.isSelected() ? Color.BLACK : Color.WHITE;
        Circle circle = new Circle(mouseEvent.getX(), mouseEvent.getY(), 4, color);
        drawingAreaPane.getChildren().add(circle);
    }
}
