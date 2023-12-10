package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 27-Mar-20
 */
@LeetCode(id = 28, name = "Implement strStr()", url = "https://leetcode.com/problems/implement-strstr/")
public class ImplementStrStr {
	private int[] kmp(String needle) {
		int left = 0;
		int right = 1;
		int[] kmp = new int[needle.length()];

		while (right < needle.length()) {
			if (needle.charAt(left) == needle.charAt(right)) {
				kmp[right] = ++left;
				right++;
			}
			else {
				if (left == 0) {
					right++;
				}
				else {
					left = kmp[left - 1];
				}
			}
		}

		return kmp;
	}

	public int strStr(String haystack, String needle) {
		if (needle == null || needle.length() == 0) {
			return 0;
		}

		if (needle.length() > haystack.length()) {
			return -1;
		}

		if (needle.length() == haystack.length()) {
			return haystack.equals(needle) ? 0 : -1;
		}

		int[] kmp = kmp(needle);
		int haystackPosition = 0;
		int needlePosition = 0;
		while (haystackPosition < haystack.length()) {
			if (haystack.charAt(haystackPosition) == needle.charAt(needlePosition)) {
				haystackPosition++;
				needlePosition++;
				if (needlePosition == needle.length()) {
					return haystackPosition - needlePosition;
				}
			}
			else {
				if (needlePosition == 0) {
					haystackPosition++;
				}
				else {
					needlePosition = kmp[needlePosition - 1];
				}
			}
		}


		return -1;
	}
}
