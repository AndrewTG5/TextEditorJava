package com.example.texteditor;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class MainApplicationTest {

    @Test
    @DisplayName("Test MainApplication.readFile() with test.txt")
    void testReadFile() {
        String content = "This is an example test file." + System.lineSeparator() +
                System.lineSeparator() +
                "There is a blank line above this one!" + System.lineSeparator();
        assertEquals(content, MainApplication.readFile(new File("src/test/resources/test.txt")));
    }

    @Test
    @DisplayName("Test MainApplication.isUnsaved() with test.txt and modified content")
    void testIsUnsaved() {
        String content = "This is an example test file." + System.lineSeparator() +
                System.lineSeparator() +
                "There is a blank line above this one!f" + System.lineSeparator();
        assertTrue(MainApplication.isUnsaved(new File("src/test/resources/test.txt"), content));
    }

    @Test
    @DisplayName("Test false MainApplication.isUnsaved() with test.txt and content")
    void testIsUnsavedFalse() {
        String content = "This is an example test file." + System.lineSeparator() +
                System.lineSeparator() +
                "There is a blank line above this one!" + System.lineSeparator();
        assertFalse(MainApplication.isUnsaved(new File("src/test/resources/test.txt"), content));
    }

    @Test
    @DisplayName("Test MainApplication.isUnsaved() with null and content")
    void testIsUnsavedNull() {
        String content = "This is an example test file." + System.lineSeparator() +
                System.lineSeparator() +
                "There is a blank line above this one!f" + System.lineSeparator();
        assertTrue(MainApplication.isUnsaved(null, content));
    }

    @Test
    @DisplayName("Test false MainApplication.isUnsaved() with null and blank content")
    void testIsUnsavedNew() {
        String content = "";
        assertFalse(MainApplication.isUnsaved(null, content));
    }

    @Test
    @DisplayName("Test MainApplication.isUnsaved() with test.odt and modified content")
    void testIsUnsavedODT() {
        String content = "This is an example opendocument test file." + System.lineSeparator() +
                System.lineSeparator() +
                "There is a blank line above this one!f" + System.lineSeparator();
        assertTrue(MainApplication.isUnsaved(new File("src/test/resources/test.odt"), content));
    }

    @Test
    @DisplayName("Test false MainApplication.isUnsaved() with test.odt and content")
    void testIsUnsavedFalseODT() {
        String content = "This is an example opendocument test file." + System.lineSeparator() +
                System.lineSeparator() +
                "There is a blank line above this one!" + System.lineSeparator();
        assertFalse(MainApplication.isUnsaved(new File("src/test/resources/test.odt"), content));
    }

    @Test
    @DisplayName("Test MainApplication.saveFile() by saving a file and reading it again")
    void testSaveFile() {
        String content = "This is an example test file." + System.lineSeparator() +
                System.lineSeparator() +
                "There is a blank line above this one!" + System.lineSeparator();
        MainApplication.saveFile(new File("src/test/resources/testoutput.txt"), content);
        assertEquals(content, MainApplication.readFile(new File("src/test/resources/testoutput.txt")));
    }

    @AfterAll
    @DisplayName("delete the file created by testSaveFile()")
    static void tearDown() {
        File file = new File("src/test/resources/testoutput.txt");
        if (!file.delete()) {
            System.out.println("Could not delete testoutput.txt!");
        }
    }

}