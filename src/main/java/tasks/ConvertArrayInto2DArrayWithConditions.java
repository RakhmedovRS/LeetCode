package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Ruslan Rakhmedov
 * @created 4/6/2023
 */
@LeetCode(
		id = 2610,
		name = "Convert an Array Into a 2D Array With Conditions",
		url = "https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions/description/",
		difficulty = Difficulty.MEDIUM
)
public class ConvertArrayInto2DArrayWithConditions {
	public List<List<Integer>> findMatrix(int[] nums) {
		List<List<Integer>> lists = new LinkedList<>();
		int[] memo = new int[201];
		for (int num : nums) {
			memo[num]++;
		}

		boolean seen = true;
		while (seen) {
			List<Integer> list = new ArrayList<>();
			seen = false;
			for (int i = 0; i < memo.length; i++) {
				if (memo[i] > 0) {
					seen = true;
					list.add(i);
					memo[i]--;
				}
			}

			if (!list.isEmpty()) {
				lists.add(list);
			}

		}

		return lists;
	}
}
