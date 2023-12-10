package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 14-Mar-20
 */
@LeetCode(id = 14, name = "Longest Common Prefix", url = "https://leetcode.com/problems/longest-common-prefix/")
public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}

		int minLength = Integer.MAX_VALUE;
		for (String str : strs) {
			minLength = Math.min(minLength, str.length());
		}

		StringBuilder commonPrefix = new StringBuilder();
		outer:
		for (int index = 0; index < minLength; index++) {
			char currentChar = strs[0].charAt(index);
			for (int wordPos = 0; wordPos < strs.length; wordPos++) {
				if (index >= strs[wordPos].length()) {
					break outer;
				}

				if (strs[wordPos].charAt(index) != currentChar) {
					break outer;
				}
			}
			commonPrefix.append(currentChar);
		}

		return commonPrefix.toString();
	}

	public static void main(String[] args) {
		System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
		System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{"a"}));
		System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{"a", ""}));
	}
}
