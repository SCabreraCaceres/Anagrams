package com.exercise.anagrams;

import java.io.BufferedReader;
import java.io.IOException;

import static org.apache.commons.lang3.StringUtils.isNumeric;

public class UserInput {

    private static final String EXIT = "exit";
    private final BufferedReader bufferedReader;

    public UserInput(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public String askUserInput() throws IOException {
        String input;
        do {
            System.out.print("Enter word or sentence or type 'exit' to quit: ");
            input = bufferedReader.readLine();
        } while(invalid(input) && !isExitCommand(input));
        return input;
    }

    private boolean invalid(String input) {
        return input.isBlank() || input.isEmpty() || isNumeric(input);
    }

    private boolean isExitCommand(String input) {
        return EXIT.equalsIgnoreCase(input);
    }
}
