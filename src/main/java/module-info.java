module com.example.texteditor {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;
    requires odfdom.java;
    requires org.apache.commons.io;

    opens com.example.texteditor to javafx.fxml;
    exports com.example.texteditor;
}