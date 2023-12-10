package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 08-Jun-20
 */
@LeetCode(id = 541, name = "Reverse String II", url = "https://leetcode.com/problems/reverse-string-ii/")
public class ReverseStringII {
	public String reverseStr(String s, int k) {
		char[] letters = s.toCharArray();

		reverse(letters, 0, k);
		return String.valueOf(letters);
	}

	private void reverse(char[] letters, int pos, int k) {
		if (pos >= letters.length) {
			return;
		}

		int left = pos;
		int right = Math.min(letters.length - 1, pos + k - 1);
		while (left < right) {
			char temp = letters[left];
			letters[left] = letters[right];
			letters[right] = temp;
			left++;
			right--;
		}

		reverse(letters, pos + k * 2, k);
	}

	public static void main(String[] args) {
		System.out.println(new ReverseStringII().reverseStr("abcdefg", 2));
	}
}
