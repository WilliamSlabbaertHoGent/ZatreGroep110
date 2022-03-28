module Zatre {
    exports gui;
    /*exports testing;*/
    exports cui;
    exports controller;
    exports persistence;
    exports exceptions;
    exports domain;
    exports main;
    exports resources;

    requires mysql.connector.java;
    requires java.sql;
    requires java.base;
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires org.junit.jupiter;

//    opens gui to javafx.graphics;
//    opens main to javafx.graphics;
}