package com.exercise.anagrams;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Stream;

import static java.nio.file.Files.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;

public class DictionaryFilesLoaderTest {

    private DictionaryFilesLoader loader = new DictionaryFilesLoader();

    @Test
    void pathDoesNotExistReturnsEmpty() {
        Stream<String> data = loader.readLines(null);

        assertEquals(0, data.count());
    }

    @Test
    void fileDoesNotExistReturnsEmpty() {
        Stream<String> data = loader.readLines(Path.of("/test"));
        assertEquals(0, data.count());
    }

    @Test
    void loadsContentInFileFromGivenPath() throws IOException {
        Path tempDir = createTempFile("test", ".txt");
        String expectedData = "Hello, world!";
        writeString(tempDir, expectedData);

        Stream<String> data = loader.readLines(tempDir);

        assertEquals(expectedData, data.findFirst().get());

        deleteIfExists(tempDir);
    }

    @Test
    void loadsContentInFilesFromGivenPath() throws IOException {
        Path tmpDir = createTempDirectory("lc");
        Path tempFile1 = createTempFile(tmpDir, "test1", ".txt");
        Path tempFile2 = createTempFile(tmpDir, "test2", ".txt");
        String text1 = "Hello, world!";
        String text2 = "How are you?";
        writeString(tempFile1, text1);
        writeString(tempFile2, text2);

        Stream<String> data = loader.readLines(tmpDir);

        assertLinesMatch(Stream.of(text1,text2).sorted(), data.sorted());

        deleteIfExists(tempFile1);
        deleteIfExists(tempFile2);
    }
}
