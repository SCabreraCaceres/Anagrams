package com.exercise.anagrams;

import static java.util.Arrays.sort;

public class AnagramsFinder {
	
	private final String text;

	public AnagramsFinder(String text) {
		this.text = text;
	}

	public boolean searchAnagrams(String dictionaryLine) {
		return wordsAreNotNull(dictionaryLine)
				&& wordsAreNotBlank(dictionaryLine)
				&& wordsHaveMoreThanOneCharacter(dictionaryLine)
				&& wordsAreNotEqual(dictionaryLine)
				&& wordsAreAnagrams(dictionaryLine);
	}

	private boolean wordsAreNotNull(String dictionaryLine) {
		return null != text && null != dictionaryLine;
	}
	
	private boolean wordsAreNotBlank(String dictionaryLine) {
		return !text.isBlank() && !dictionaryLine.isBlank();
	}

	private boolean wordsHaveMoreThanOneCharacter(String dictionaryLine) {
		return text.length() > 1 && dictionaryLine.length() > 1;
	}
	
	private boolean wordsAreNotEqual(String dictionaryLine) {
		return !text.equalsIgnoreCase(dictionaryLine);
	}

	private boolean wordsAreAnagrams(String dictionaryLine) {
		char[] charsInText = text.replace(" ", "")
				.toLowerCase().toCharArray();
		char[] charsInLine = dictionaryLine.replace(" ", "")
				.toLowerCase().toCharArray();
		sort(charsInText);
		sort(charsInLine);
		return new String(charsInText).equals(new String(charsInLine));
	}
	
}
