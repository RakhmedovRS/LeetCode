package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-06-22
 */
@LeetCode(
		id = 3192,
		name = "Minimum Operations to Make Binary Array Elements Equal to One II",
		url = "https://leetcode.com/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-ii/description/",
		difficulty = Difficulty.MEDIUM
)
public class MinimumOperationsToMakeBinaryArrayElementsEqualToOneII {
	public int minOperations(int[] nums) {
		LinkedList<Integer> list = new LinkedList<>();
		for (int num : nums) {
			if (list.isEmpty() || list.getLast() != num) {
				list.add(num);
			}
		}

		if (list.getFirst() == 1) {
			return list.size() - 1;
		}
		return list.size();
	}
}