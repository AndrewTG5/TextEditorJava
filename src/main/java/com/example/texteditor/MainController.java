package com.example.texteditor;

import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;

import java.io.File;

public class MainController {

    public TextArea textArea;

    public void onNew(ActionEvent actionEvent) {

    }

    public void onOpen(ActionEvent actionEvent) {
        File file = MainApplication.getFile();
        if (file != null) {
            textArea.setText(MainApplication.readFile(file));
        }
    }

    public void onSave(ActionEvent actionEvent) {

    }

    public void onSaveAs(ActionEvent actionEvent) {

    }

    public void onExit(ActionEvent actionEvent) {
        System.exit(0);
    }
}