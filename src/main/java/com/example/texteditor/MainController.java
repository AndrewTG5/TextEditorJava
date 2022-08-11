package com.example.texteditor;

import javafx.scene.control.TextArea;

import java.io.File;

public class MainController {

    public TextArea textArea;

    private File currentFile;

    public void onNew() {
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