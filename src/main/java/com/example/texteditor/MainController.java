package com.example.texteditor;

import eu.mihosoft.monacofx.*;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.StackPane;

import java.io.File;

public class MainController {

    public MonacoFX textArea = new MonacoFX();
    public StackPane editorPane;

    public void initialize() {
        editorPane.getChildren().add(textArea);
    }

    private File currentFile = null;

    public void onNew() {
        MainApplication.newWindow();
    }

    public void onOpen() {
        currentFile = MainApplication.getFile();
        if (currentFile != null) {
            textArea.getEditor().getDocument().setText(MainApplication.readFile(currentFile));
        }
    }

    public void onSave() {
        if (currentFile != null) {
            MainApplication.saveFile(currentFile, textArea.getEditor().getDocument().getText());
        } else {
            onSaveAs();
        }
    }

    public void onSaveAs() {
        currentFile = MainApplication.chooseSaveFile();
        MainApplication.saveFile(currentFile, textArea.getEditor().getDocument().getText());
    }

    public void onExit() {
        if (MainApplication.isUnsaved(currentFile, textArea.getEditor().getDocument().getText())) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Save");
            alert.setHeaderText("Do you want to save changes?");
            alert.setContentText("Your changes will be lost if you don't save them.");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
                onSave();
            }
        }
    }

    public void onDate() {
        textArea.getEditor().getDocument().setText(MainApplication.getCurrentDateTime() + textArea.getEditor().getDocument().getText());
    }

    public void onCut() {
        //textArea.cut();
    }

    public void onCopy() {
        //textArea.copy();
    }

    public void onPaste() {
        //textArea.paste();
    }

    public void onSelectAll() {
        //textArea.selectAll();
    }
}