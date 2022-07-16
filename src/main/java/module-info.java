module ec.edu.ista.marlon.appdesk_consumoapi {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens ec.edu.ista.marlon.appdesk_consumoapi to javafx.fxml;
    exports ec.edu.ista.marlon.appdesk_consumoapi;
}