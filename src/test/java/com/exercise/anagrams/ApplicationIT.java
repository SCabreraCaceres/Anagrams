package com.exercise.anagrams;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApplicationIT {

    public static final String TEST_FILE = "test.txt";
    public static final String USER_INPUT = "userinput";

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputCaptor = new ByteArrayOutputStream();

    private String absolutePath;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputCaptor));

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(TEST_FILE).getFile());
        absolutePath = file.getAbsolutePath();

    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void noAnagrams() throws IOException {
        String[] args = {absolutePath};
        System.setProperty(USER_INPUT, "");

        Application.main(args);

        assertEquals("No anagrams found :(",
                outputCaptor.toString().trim());
    }

    @Test
    void anagramFound() throws IOException {
        String[] args = {absolutePath};
        System.setProperty(USER_INPUT, "te st");

        Application.main(args);

        assertEquals("Longest anagram is es tt",
                outputCaptor.toString().trim());
    }

    @Test
    void fileDoesNotExistFound() throws IOException {
        String[] args = {"/test"};
        System.setProperty(USER_INPUT, "test");

        Application.main(args);

        assertTrue(outputCaptor.toString().trim()
                .contains("No anagrams found :("));
    }
}
