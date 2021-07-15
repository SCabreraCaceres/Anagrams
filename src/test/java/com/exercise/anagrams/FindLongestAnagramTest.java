package com.exercise.anagrams;

import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.stream.Stream;

import static com.exercise.anagrams.FindLongestAnagram.find;
import static org.junit.jupiter.api.Assertions.*;

class FindLongestAnagramTest {


    @Test
    void findsLongestAnagram() {
        Stream<String> anagrams = Stream.of("Moon starer", "remonortsa");

        assertEquals("Moon starer",
                find(anagrams, "Astronomer").get());
    }

    @Test
    void notFindsLongestAnagram() {
        Stream<String> anagrams = Stream.of("Moon starer", "remonortsa");

        assertEquals(Optional.empty(), find(anagrams, "We"));
    }
}