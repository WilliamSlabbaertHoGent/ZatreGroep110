module Zatre {
    exports gui;
    /*exports testing;*/
    exports cui;
    exports controller;
    exports persistence;
    exports exceptions;
    exports domain;
    exports main;

    requires mysql.connector.java;
    requires java.sql;
    requires java.base;
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

//    opens gui to javafx.graphics;
//    opens main to javafx.graphics;
}