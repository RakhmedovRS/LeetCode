package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 13-Apr-20
 */
@LeetCode(
		id = 525,
		name = "Contiguous Array",
		url = "https://leetcode.com/problems/contiguous-array/",
		difficulty = Difficulty.MEDIUM
)
public class ContiguousArray {
	public int findMaxLength(int[] nums) {
		Map<Integer, Integer> memo = new HashMap<>();
		memo.put(0, -1);
		int count = 0;
		int maxLen = 0;
		for (int i = 0; i < nums.length; i++) {
			count += nums[i] == 1 ? 1 : -1;
			Integer prevIndex = memo.get(count);
			if (prevIndex != null) {
				maxLen = Math.max(maxLen, i - prevIndex);
			}
			else {
				memo.put(count, i);
			}
		}

		return maxLen;
	}
}
