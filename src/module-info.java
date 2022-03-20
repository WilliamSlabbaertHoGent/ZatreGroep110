module Zatre {
    exports gui;

    requires java.base;
    requires javafx.graphics;
    requires javafx.controls;
    requires mysql.connector.java;
    requires java.sql;
    requires org.junit.jupiter.api;

    opens gui to javafx.graphics;

}