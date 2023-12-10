package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 6/11/2023
 */
@LeetCode(
		id = 2734,
		name = "Lexicographically Smallest String After Substring Operation",
		url = "https://leetcode.com/problems/lexicographically-smallest-string-after-substring-operation/",
		difficulty = Difficulty.MEDIUM
)
public class LexicographicallySmallestStringAfterSubstringOperation {
	public String smallestString(String s) {
		char[] chars = s.toCharArray();
		if (s.length() == 1) {
			shift(chars, 0);
			return String.valueOf(chars);
		}

		int posA = 0;
		while (posA < chars.length - 1 && chars[posA] == 'a') {
			posA++;
		}

		boolean changed = false;
		while (posA < chars.length) {
			if (chars[posA] == 'a' && changed) {
				break;
			}

			shift(chars, posA++);
			changed = true;
		}

		return String.valueOf(chars);
	}

	private void shift(char[] chars, int pos) {
		if (chars[pos] == 'a') {
			chars[pos] = 'z';
		}
		else {
			chars[pos] -= 1;
		}
	}
}
