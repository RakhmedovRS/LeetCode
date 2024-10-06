package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
import java.util.List;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-10-05
 */
@LeetCode(
		id = 3309,
		name = "Maximum Possible Number by Binary Concatenation",
		url = "https://leetcode.com/problems/maximum-possible-number-by-binary-concatenation/description/",
		difficulty = Difficulty.MEDIUM
)
public class MaximumPossibleNumberByBinaryConcatenation {
	public int maxGoodNumber(int[] nums) {
		int max = 0;
		String abc = Integer.toBinaryString(nums[0]) + Integer.toBinaryString(nums[1]) + Integer.toBinaryString(nums[2]);
		String acb = Integer.toBinaryString(nums[0]) + Integer.toBinaryString(nums[2]) + Integer.toBinaryString(nums[1]);
		String bac = Integer.toBinaryString(nums[1]) + Integer.toBinaryString(nums[0]) + Integer.toBinaryString(nums[2]);
		String bca = Integer.toBinaryString(nums[1]) + Integer.toBinaryString(nums[2]) + Integer.toBinaryString(nums[0]);
		String cab = Integer.toBinaryString(nums[2]) + Integer.toBinaryString(nums[0]) + Integer.toBinaryString(nums[1]);
		String cba = Integer.toBinaryString(nums[2]) + Integer.toBinaryString(nums[1]) + Integer.toBinaryString(nums[0]);
		List<String> stringList = Arrays.asList(abc, acb, bac, bca, cab, cba);
		for (String s : stringList) {
			max = Math.max(max, Integer.parseInt(s, 2));
		}
		return max;
	}
}