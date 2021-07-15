package com.exercise.anagrams;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class UserInputTest {

    public static final String TEST = "test";
    private static final String EXIT = "exit";

    @Mock
    private BufferedReader bufferedReader;

    @InjectMocks
    private UserInput userInput;

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void userInsertsExit() throws IOException {
        given(bufferedReader.readLine()).willReturn(EXIT);

        assertEquals(EXIT, userInput.askUserInput());
        assertEquals("Enter word or sentence or type 'exit' to quit:",
                outputCaptor.toString().trim());
    }

    @Test
    void userInsertsValidWord() throws IOException {
        given(bufferedReader.readLine()).willReturn(TEST);

        assertEquals(TEST, userInput.askUserInput());
        assertEquals("Enter word or sentence or type 'exit' to quit:",
                outputCaptor.toString().trim());
    }
}
