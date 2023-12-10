package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 26-Jul-20
 */
@LeetCode(id = 1528, name = "Shuffle String", url = "https://leetcode.com/problems/shuffle-string/")
public class ShuffleString {
	public String restoreString(String s, int[] indices) {
		char[] chars = new char[s.length()];
		for (int i = 0; i < indices.length; i++) {
			chars[indices[i]] = s.charAt(i);
		}

		return String.valueOf(chars);
	}
}
