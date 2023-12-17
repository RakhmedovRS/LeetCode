package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Ruslan Rakhmedov
 * @created 12/16/2023
 */
@LeetCode(
		id = 2966,
		name = "Divide Array Into Arrays With Max Difference",
		url = "https://leetcode.com/problems/divide-array-into-arrays-with-max-difference/description/",
		difficulty = Difficulty.MEDIUM
)
public class DivideArrayIntoArraysWithMaxDifference {
	public int[][] divideArray(int[] nums, int k) {
		Arrays.sort(nums);
		List<List<Integer>> temp = new ArrayList<>();
		List<Integer> curr = new ArrayList<>();
		for (int num : nums) {
			if (curr.isEmpty()) {
				curr.add(num);
			}
			else {
				if (curr.size() == 3) {
					temp.add(curr);
					curr = new LinkedList<>();
					curr.add(num);
					continue;
				}

				if (num - curr.get(0) <= k) {
					curr.add(num);
				}
				else if (curr.size() < 3) {
					return new int[0][];
				}
				else {
					temp.add(curr);
					curr = new LinkedList<>();
					curr.add(num);
				}
			}
		}

		if (curr.size() < 3) {
			return new int[0][];
		}

		temp.add(curr);

		int[][] ans = new int[temp.size()][];
		for (int i = 0; i < temp.size(); i++) {
			int[] vals = new int[temp.get(i).size()];
			int pos = 0;
			while (!temp.get(i).isEmpty()) {
				vals[pos] = temp.get(i).get(pos++);
			}
			ans[i] = vals;
		}

		return ans;
	}
}
