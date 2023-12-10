package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 18-May-20
 */
@LeetCode(id = 567, name = "Permutation in String", url = "https://leetcode.com/problems/permutation-in-string/")
public class PermutationInString {
	public boolean checkInclusion(String s1, String s2) {
		if (s1 == null || s1.isEmpty() || s2 == null || s2.isEmpty()) {
			return false;
		}

		int[] cache = new int[26];
		for (char ch : s1.toCharArray()) {
			cache[ch - 'a']--;
		}

		int patternSize = s1.length();
		for (int i = 0; i < s2.length(); i++) {
			char ch = s2.charAt(i);
			cache[ch - 'a']++;
			if (i < patternSize - 1) {
				continue;
			}

			if (i >= patternSize) {
				cache[s2.charAt(i - patternSize) - 'a']--;
			}

			if (check(cache)) {
				return true;
			}
		}

		return check(cache);
	}

	private boolean check(int[] arr) {
		for (int num : arr) {
			if (num < 0) {
				return false;
			}
		}

		return true;
	}
}
