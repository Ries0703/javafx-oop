module com.painter.javafxoop {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.desktop;
    requires static lombok;
    requires javafx.swing;
    requires com.fasterxml.jackson.databind;

    opens com.painter.ict.aims.model.media to javafx.base;
    opens com.painter.javafxoop to javafx.fxml;
    exports com.painter.javafxoop;
    exports com.painter.ict.aims.model.cart;
    exports com.painter.ict.aims.view; // Export the nested package
    exports com to javafx.graphics;
}