package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11/7/2021
 */
@LeetCode(
		id = 2062,
		name = "Count Vowel Substrings of a String",
		url = "https://leetcode.com/problems/count-vowel-substrings-of-a-string/",
		difficulty = Difficulty.EASY
)
public class CountVowelSubstringsOfString {
	public int countVowelSubstrings(String word) {
		int count = 0;
		char[] chars = word.toCharArray();
		for (int i = 0; i < word.length(); i++) {
			boolean[] arr = new boolean[26];
			for (int j = i; j < word.length(); j++) {
				if (chars[j] != 'a' && chars[j] != 'e' && chars[j] != 'i' && chars[j] != 'o' && chars[j] != 'u') {
					break;
				}
				arr[chars[j] - 'a'] = true;
				if (arr['a' - 'a'] && arr['e' - 'a'] && arr['i' - 'a'] && arr['o' - 'a'] && arr['u' - 'a']) {
					count++;
				}
			}
		}

		return count;
	}
}
