package com.example.texteditor;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;

import java.io.File;

public class MainController {

    public TextArea textArea;

    private File currentFile = null;

    public void onNew() {
        if (MainApplication.isUnsaved(currentFile, textArea.getText())) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Save");
            alert.setHeaderText("Do you want to save changes?");
            alert.setContentText("Your changes will be lost if you don't save them.");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
                onSave();
            }
        }
        textArea.clear();
        currentFile = null;
    }

    public void onOpen() {
        currentFile = MainApplication.getFile();
        if (currentFile != null) {
            textArea.setText(MainApplication.readFile(currentFile));
        }
    }

    public void onSave() {
        if (currentFile != null) {
            MainApplication.saveFile(currentFile, textArea.getText());
        } else {
            onSaveAs();
        }
    }

    public void onSaveAs() {
        currentFile = MainApplication.chooseSaveFile();
        MainApplication.saveFile(currentFile, textArea.getText());
    }

    public void onExit() {
        System.exit(0);
    }

    public void onDate() {
        // passing 0 will insert the date at the very beginning of the textArea
        textArea.insertText(0, MainApplication.getCurrentDateTime());
    }

    public void onCut() {
    }

    public void onCopy() {
    }

    public void onPaste() {
    }

    public void onSelectAll() {
    }
}