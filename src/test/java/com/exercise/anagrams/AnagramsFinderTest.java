package com.exercise.anagrams;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.apache.commons.lang3.StringUtils.SPACE;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AnagramsFinderTest {

    private static final String EMPTY = StringUtils.EMPTY;
    private static final String BLANK = SPACE;
    private static final String ONE_LETTER = "A";
    private static final String TEST = "test";

    private AnagramsFinder finder;

    @ParameterizedTest(name = "{index} {0} and {1} are not anagrams")
    @MethodSource
    void nullAndEmptyWordsAreNotAnagrams(String word1, String word2) {
        finder = new AnagramsFinder(word1);

        assertFalse(finder.searchAnagrams(word2));
    }

    @ParameterizedTest(name = "{index} {0} and {1} are not anagrams")
    @MethodSource
    void wordsWithLessThanTwoLettersAreNotAnagrams(String word1, String word2) {
        finder = new AnagramsFinder(word1);

        assertFalse(finder.searchAnagrams(word2));
    }

    @Test
    void equalWordsAreNotAnagrams() {
        finder = new AnagramsFinder(TEST);

        assertFalse(finder.searchAnagrams(TEST));
    }

    @ParameterizedTest(name = "{index} {0} and {1} are anagrams")
    @MethodSource
    void wordsAreAnagramsIgnoringCase(String word1, String word2) {
        finder = new AnagramsFinder(word1);

        assertTrue(finder.searchAnagrams(word2));
    }

    private static Stream<Arguments> nullAndEmptyWordsAreNotAnagrams() {
        return Stream.of(
                Arguments.of(null, TEST),
                Arguments.of(TEST, null),
                Arguments.of(BLANK, TEST),
                Arguments.of(TEST, BLANK),
                Arguments.of(EMPTY, TEST),
                Arguments.of(TEST, EMPTY)
        );
    }

    private static Stream<Arguments> wordsWithLessThanTwoLettersAreNotAnagrams() {
        return Stream.of(
                Arguments.of(ONE_LETTER, TEST),
                Arguments.of(TEST, ONE_LETTER)
        );
    }

    private static Stream<Arguments> wordsAreAnagramsIgnoringCase() {
        return Stream.of(
                Arguments.of(TEST, "sett"),
                Arguments.of("TEST", "SETT"),
                Arguments.of("Astronomer", "Moon starer"),
                Arguments.of("Statue of Liberty", "Built to stay free")
        );
    }
}