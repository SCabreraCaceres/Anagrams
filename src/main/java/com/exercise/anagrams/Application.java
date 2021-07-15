package com.exercise.anagrams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.Optional;
import java.util.stream.Stream;

import static com.exercise.anagrams.FindLongestAnagram.find;

public class Application {

    private static final String EXIT = "EXIT";

    public static void main(String[] args) throws IOException {

        DictionaryFilesLoader fileLoader = new DictionaryFilesLoader();
        String parameterizedInput = System.getProperty("userinput");
        UserInput userInput = new UserInput(new BufferedReader(new InputStreamReader(System.in)));

        Stream<String> textsInDictionary = fileLoader.readLines(Path.of(args[0]));

        String input = parameterizedInput == null ? userInput.askUserInput() : parameterizedInput;

        if (!input.equalsIgnoreCase(EXIT)) {
            Optional<String> longestAnagram = find(textsInDictionary, input);

            if (longestAnagram.isPresent()) {
                System.out.println("Longest anagram is " + longestAnagram.get());
            } else {
                System.out.println("No anagrams found :(");
            }
        }
    }

}
