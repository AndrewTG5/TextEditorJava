module com.example.texteditor {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.graphics;
    requires javafx.media;
    requires java.xml;
    requires odfdom.java;
    requires org.apache.commons.io;
    requires eu.mihosoft.monacofx;

    opens com.example.texteditor to javafx.fxml;
    exports com.example.texteditor;
}