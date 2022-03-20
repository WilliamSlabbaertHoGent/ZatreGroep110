module Zatre {
    exports gui;
    exports testing;
    exports cui;

    requires java.base;
    requires javafx.graphics;
    requires javafx.controls;
    opens gui to javafx.graphics;
    exports main;
    opens main to javafx.graphics;

    requires mysql.connector.java;
    requires java.sql;

    requires org.apiguardian.api;
    requires org.junit.platform.commons;
    requires org.opentest4j;
    requires org.junit.jupiter.api;
    requires org.junit.jupiter.params;

}