package tasks;

import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 11/7/2020
 */
@LeetCode(id = 966, name = "Vowel Spellchecker", url = "https://leetcode.com/problems/vowel-spellchecker/")
public class VowelSpellchecker {
	public String[] spellchecker(String[] wordlist, String[] queries) {
		Set<String> normal = new HashSet<>();
		Map<String, String> lower = new HashMap<>();
		Map<String, String> vowelError = new HashMap<>();
		for (String word : wordlist) {
			normal.add(word);
			lower.putIfAbsent(word.toLowerCase(), word);
			vowelError.putIfAbsent(removeVowels(word), word);
		}

		String[] answer = new String[queries.length];
		String lowered;
		String withoutVowels;
		for (int i = 0; i < queries.length; i++) {
			if (normal.contains(queries[i])) {
				answer[i] = queries[i];
				continue;
			}

			lowered = queries[i].toLowerCase();
			if (lower.containsKey(lowered)) {
				answer[i] = lower.get(lowered);
				continue;
			}

			withoutVowels = removeVowels(queries[i]);
			if (vowelError.containsKey(withoutVowels)) {
				answer[i] = vowelError.get(withoutVowels);
				continue;
			}

			answer[i] = "";
		}

		return answer;
	}

	private String removeVowels(String word) {
		StringBuilder sb = new StringBuilder();
		for (char ch : word.toCharArray()) {
			if (isVowel(Character.toLowerCase(ch))) {
				sb.append('*');
			}
			else {
				sb.append(Character.toLowerCase(ch));
			}
		}
		return sb.toString();
	}

	private boolean isVowel(char ch) {
		return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(new VowelSpellchecker().spellchecker(new String[]{"KiTe", "kite", "hare", "Hare"}, new String[]{"kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto"})));
	}
}
