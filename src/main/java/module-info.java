module main {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires com.jfoenix;
    requires javafx.media;
    requires java.sql;
    requires java.desktop;
    requires java.base;

    opens main to javafx.fxml;
    opens main.controller to javafx.fxml;
    opens main.model to javafx.fxml;
    opens main.utill to javafx.fxml;
    opens main.controller.meditation to javafx.fxml;
    opens main.controller.splashscreen to javafx.fxml;

    exports main;
    exports main.controller;
    exports main.model;
    exports main.utill;
    exports main.controller.meditation;
    exports main.controller.splashscreen;
}
