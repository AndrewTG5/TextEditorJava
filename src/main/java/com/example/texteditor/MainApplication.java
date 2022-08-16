package com.example.texteditor;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class MainApplication extends Application {

    MainController controller;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        controller = fxmlLoader.getController();
        stage.setTitle("Text Editor");
        stage.setScene(scene);
        stage.setOnCloseRequest(e -> {controller.onNew(); System.exit(0);});
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    /**
     * Opens a file chooser dialog and returns the selected file.
     * @return The selected file
     */
    public static File getFile() {
        FileChooser fileChooser = new FileChooser();
        // specify allowed file types
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text files (*.txt)", "*.txt"));
        //set initial directory
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));

        return fileChooser.showOpenDialog(null);
    }

    /**
     * Reads a file and returns its content.
     * @param file The file to read. Usually obtained from getFile().
     * @return The content of the file.
     */
    public static String readFile(File file) {
        StringBuilder content = new StringBuilder();
        try {
            // FileReader reads text files in the default encoding.
            java.io.FileReader fileReader = new java.io.FileReader(file);
            // Always wrap FileReader in BufferedReader.
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line);
                content.append(System.lineSeparator());
            }
            bufferedReader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return content.toString();
    }

    /**
     * Opens a file chooser dialog and returns the File to save to.
     * @return The File to save to.
     */
    public static File chooseSaveFile() {
        FileChooser fileChooser = new FileChooser();
        // specify allowed file types
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text files (*.txt)", "*.txt"));
        //set initial directory
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));

        return fileChooser.showSaveDialog(null);
    }

    /**
     * Saves a file.
     * @param file The file to save. Usually obtained from chooseSaveFile() or getFile().
     * @param content The content to save.
     */
    public static void saveFile(File file, String content) {
        try {
            // FileWriter overwrites any existing file.
            java.io.FileWriter fileWriter = new java.io.FileWriter(file);
            // Always wrap FileWriter in BufferedWriter.
            java.io.BufferedWriter bufferedWriter = new java.io.BufferedWriter(fileWriter);
            bufferedWriter.write(content);
            bufferedWriter.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Returns a string with the current date and time.
     * @return A string with the current date and time.
     */
    public static String getCurrentDateTime() {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("HH:mm aa yyyy/MM/dd");
        return sdf.format(new java.util.Date());
    }

    /**
     * Returns true if the file has not been saved.
     * @param file The file to check. Can be null
     * @param content The content of the editor
     * @return True if the file has not been saved.
     */
    public static boolean isUnsaved(File file, String content) {
        if (file == null && content.isEmpty()) {
            return false;
        } else if (file == null) {
            return true;
        }
        return !readFile(file).equals(content);
    }
}