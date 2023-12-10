package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Ruslan Rakhmedov
 * @created 5/13/2023
 */
@LeetCode(
		id = 2679,
		name = "Sum in a Matrix",
		url = "https://leetcode.com/problems/sum-in-a-matrix/",
		difficulty = Difficulty.MEDIUM
)
public class SumInMatrix {
	public int matrixSum(int[][] nums) {
		List<List<Integer>> lists = new ArrayList<>();
		int rows = nums.length;
		int columns = nums[0].length;
		for (int row = 0; row < rows; row++) {
			List<Integer> list = new ArrayList<>();
			for (int val : nums[row]) {
				list.add(val);
			}
			list.sort(Comparator.reverseOrder());
			lists.add(list);
		}

		int s = 0;
		for (int column = 0; column < columns; column++) {
			int max = 0;
			for (int row = 0; row < rows; row++) {
				max = Math.max(max, lists.get(row).get(column));
			}
			s += max;
		}

		return s;
	}
}
