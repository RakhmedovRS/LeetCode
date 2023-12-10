package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 1/11/2021
 */
@LeetCode(
		id = 267,
		name = "Palindrome Permutation II",
		url = "https://leetcode.com/problems/palindrome-permutation-ii/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class PalindromePermutationII {
	public List<String> generatePalindromes(String s) {
		List<String> answer = new ArrayList<>();
		Map<Character, Integer> map = new HashMap<>();
		for (char ch : s.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		if (canCreatePalindrome(map)) {
			Set<String> set = new HashSet<>();
			char[] chars = new char[s.length()];
			if (s.length() % 2 != 0) {
				for (Map.Entry<Character, Integer> entry : map.entrySet()) {
					if (entry.getValue() % 2 != 0) {
						map.put(entry.getKey(), entry.getValue() - 1);
						chars[s.length() / 2] = entry.getKey();
						break;
					}
				}
			}

			dfs(0, s.length() - 1, map, set, chars);
			answer.addAll(set);
		}

		return answer;
	}

	private void dfs(int left, int right, Map<Character, Integer> map, Set<String> set, char[] chars) {
		if (left >= right) {
			set.add(String.valueOf(chars));
			return;
		}

		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() > 0) {
				map.put(entry.getKey(), entry.getValue() - 2);
				chars[left] = entry.getKey();
				chars[right] = entry.getKey();
				dfs(left + 1, right - 1, map, set, chars);
				map.put(entry.getKey(), entry.getValue() + 2);
			}
		}
	}

	boolean canCreatePalindrome(Map<Character, Integer> map) {
		int count = 0;
		boolean seenOdd = false;
		for (Integer c : map.values()) {
			count += c;
			if (c % 2 != 0) {
				if (seenOdd) {
					return false;
				}
				seenOdd = true;
			}
		}

		return (seenOdd && count % 2 == 1) || (!seenOdd && count % 2 == 0);
	}
}
