package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.List;

/**
 * @author Ruslan Rakhmedov
 * @created 9/16/2023
 */
@LeetCode(
		id = 2859,
		name = "Sum of Values at Indices With K Set Bits",
		url = "https://leetcode.com/problems/sum-of-values-at-indices-with-k-set-bits/",
		difficulty = Difficulty.EASY
)
public class SumOfValuesAtIndicesWithKSetBits {
	public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
		int sum = 0;
		for (int i = 0; i < nums.size(); i++) {
			if (Integer.bitCount(i) == k) {
				sum += nums.get(i);
			}
		}
		return sum;
	}
}
