package com.exercise.anagrams;

import java.io.UncheckedIOException;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.Comparator.comparingInt;

public class FindLongestAnagram {
    static Optional<String> find(Stream<String> texts, String baseText) {
        AnagramsFinder finder = new AnagramsFinder(baseText);

        try {
            return texts.filter(finder::searchAnagrams)
                    .max(byLength());
        } catch (UncheckedIOException ex) {
            System.out.println("Error mapping files " + ex);
        }
        return Optional.empty();
    }

    private static Comparator<String> byLength() {
        return comparingInt(String::length);
    }
}