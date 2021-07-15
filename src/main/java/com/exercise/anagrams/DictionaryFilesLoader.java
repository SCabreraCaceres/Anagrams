package com.exercise.anagrams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class DictionaryFilesLoader {

    public Stream<String> readLines(Path path) {

        if(path == null) {
            return Stream.empty();
        }

        try {
            return Files.walk(path)
                    .filter(Files::isRegularFile)
                    .flatMap(this::lines)
                    .distinct();
        } catch (IOException e) {
            System.out.println("Resource does not exist " + e.getMessage());
        }
        return Stream.empty();
    }

    private Stream<String> lines(Path file) {
        try {
            return Files.lines(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
