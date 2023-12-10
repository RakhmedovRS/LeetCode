package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 01-Jul-20
 */
@LeetCode(
		id = 1461,
		name = "Check If a String Contains All Binary Codes of Size K",
		url = "https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/",
		difficulty = Difficulty.MEDIUM
)
public class CheckIfStringContainsAllBinaryCodesOfSizeK {
	public boolean hasAllCodes(String s, int k) {
		char[] chars = s.toCharArray();
		Set<Integer> set = new HashSet<>();
		int num;
		for (int left = 0, right = k - 1; right < chars.length; left++, right++) {
			num = 0;
			for (int i = right; i >= left; i--) {
				num = (num << 1);
				num ^= (chars[i] - '0');
			}

			set.add(num);
		}

		return set.size() == Math.pow(2, k);
	}
}
