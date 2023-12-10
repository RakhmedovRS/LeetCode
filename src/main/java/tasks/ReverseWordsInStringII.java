package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 1/20/2021
 */
@LeetCode(
		id = 186,
		name = "Reverse Words in a String II",
		url = "https://leetcode.com/problems/reverse-words-in-a-string-ii/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class ReverseWordsInStringII {
	public void reverseWords(char[] s) {
		reverse(0, s.length - 1, s);
		int left = 0;
		int right = 0;
		while (right < s.length) {
			if (s[right] == ' ') {
				reverse(left, right - 1, s);
				left = right + 1;
			}
			else if (right + 1 == s.length) {
				reverse(left, right, s);
			}

			right++;
		}
	}

	private void reverse(int left, int right, char[] s) {
		char temp;
		while (left < right) {
			temp = s[left];
			s[left] = s[right];
			s[right] = temp;
			left++;
			right--;
		}
	}
}
