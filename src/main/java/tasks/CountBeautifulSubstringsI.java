package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ruslan Rakhmedov
 * @created 11/25/2023
 */
@LeetCode(
		id = 2947,
		name = "Count Beautiful Substrings I",
		url = "https://leetcode.com/problems/count-beautiful-substrings-i/",
		difficulty = Difficulty.MEDIUM
)
public class CountBeautifulSubstringsI {
	public int beautifulSubstrings(String s, int k) {
		Set<Character> vowels = new HashSet<>();
		vowels.add('a');
		vowels.add('e');
		vowels.add('i');
		vowels.add('o');
		vowels.add('u');

		int res = 0;
		char[] chars = s.toCharArray();
		for (int left = 0; left < chars.length; left++) {
			int v = 0;
			int c = 0;

			if (vowels.contains(chars[left])) {
				v++;
			}
			else {
				c++;
			}

			for (int right = left + 1; right < chars.length; right++) {
				if (vowels.contains(chars[right])) {
					v++;
				}
				else {
					c++;
				}

				if (v == c && ((v * c) % k == 0)) {
					res++;
				}
			}
		}

		return res;
	}
}
