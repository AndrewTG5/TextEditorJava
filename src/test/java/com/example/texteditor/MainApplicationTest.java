package com.example.texteditor;

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

}