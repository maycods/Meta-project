module Main {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
//    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires it.unimi.dsi.fastutil;
//    requires eu.hansolo.tilesfx;


    opens Main to javafx.fxml;
    exports Main;
    exports GUI;
    opens GUI to javafx.fxml;
}