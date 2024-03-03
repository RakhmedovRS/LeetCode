package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-03-02
 */
@LeetCode(
		id = 3069,
		name = "Distribute Elements Into Two Arrays I",
		url = "https://leetcode.com/problems/distribute-elements-into-two-arrays-i/",
		difficulty = Difficulty.EASY
)
public class DistributeElementsIntoTwoArraysI {
	public int[] resultArray(int[] nums) {
		List<Integer> a = new ArrayList<>();
		List<Integer> b = new ArrayList<>();

		a.add(nums[0]);
		b.add(nums[1]);

		for (int i = 2; i < nums.length; i++) {
			if (a.get(a.size() - 1) > b.get(b.size() - 1)) {
				a.add(nums[i]);
			} else {
				b.add(nums[i]);
			}
		}

		a.addAll(b);

		for (int i = 0; i < nums.length; i++) {
			nums[i] = a.get(i);
		}

		return nums;
	}
}