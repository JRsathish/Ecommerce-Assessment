package tests;

import java.util.*;

public class DuplicateCharacters {
	public static void main(String[] args) {
		String input = "automation";
		Set<Character> seen = new HashSet<>();
		Set<Character> duplicates = new HashSet<>();

		for (char c : input.toCharArray()) {
			if (!seen.add(c)) {
				duplicates.add(c);
			}
		}
		System.out.println("Duplicate characters: " + duplicates);
	}

}
