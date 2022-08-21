package com.example.texteditor;

import eu.mihosoft.monacofx.MonacoFX;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.robot.Robot;
import org.apache.commons.io.FilenameUtils;

import java.io.File;

public class MainController {

    public MonacoFX textArea = new MonacoFX();
    public StackPane editorPane;
    public ComboBox<String> language;

    private File currentFile = null;

    public void initialize() {
        editorPane.getChildren().add(textArea);
        language.getItems().add("Plain Text");
        language.getItems().add("Java");
        language.getItems().add("C++");
        language.getItems().add("Python");
        language.setValue("Plain Text");
    }

    public void onLanguage() {
        if (language.getValue().equals("Plain Text")) {
            textArea.getEditor().setCurrentLanguage("plaintext");
        } else if (language.getValue().equals("Java")) {
            textArea.getEditor().setCurrentLanguage("java");
        } else if (language.getValue().equals("C++")) {
            textArea.getEditor().setCurrentLanguage("cpp");
        } else if (language.getValue().equals("Python")) {
            textArea.getEditor().setCurrentLanguage("python");
        }
    }

    public void onNew() {
        MainApplication.newWindow();
    }

    public void onOpen() {
        currentFile = MainApplication.getFile();
        if (currentFile != null) {
            textArea.getEditor().getDocument().setText(MainApplication.readFile(currentFile));
            if (FilenameUtils.getExtension(currentFile.getName()).equals("odt") || FilenameUtils.getExtension(currentFile.getName()).equals("txt")) {
                language.setValue("Plain Text");
            } else if (FilenameUtils.getExtension(currentFile.getName()).equals("java")) {
                language.setValue("Java");
            } else if (FilenameUtils.getExtension(currentFile.getName()).equals("cpp")) {
                language.setValue("C++");
            } else if (FilenameUtils.getExtension(currentFile.getName()).equals("py")) {
                language.setValue("Python");
            }
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
        textArea.getEditor().getDocument().setText(MainApplication.getCurrentDateTime() + System.lineSeparator() + textArea.getEditor().getDocument().getText());
    }

    public void onCut() {
        Robot r = new Robot();
        r.keyPress(KeyCode.CONTROL);
        r.keyPress(KeyCode.X);
        r.keyRelease(KeyCode.X);
        r.keyRelease(KeyCode.CONTROL);
    }

    public void onCopy() {
        Robot r = new Robot();
        r.keyPress(KeyCode.CONTROL);
        r.keyPress(KeyCode.C);
        r.keyRelease(KeyCode.C);
        r.keyRelease(KeyCode.CONTROL);
    }

    public void onPaste() {
        Robot r = new Robot();
        r.keyPress(KeyCode.CONTROL);
        r.keyPress(KeyCode.V);
        r.keyRelease(KeyCode.V);
        r.keyRelease(KeyCode.CONTROL);
    }

    public void onSelectAll() {
        Robot r = new Robot();
        r.keyPress(KeyCode.CONTROL);
        r.keyPress(KeyCode.A);
        r.keyRelease(KeyCode.A);
        r.keyRelease(KeyCode.CONTROL);
    }
}