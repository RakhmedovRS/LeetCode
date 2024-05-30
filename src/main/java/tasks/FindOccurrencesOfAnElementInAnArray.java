package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-05-29
 */
@LeetCode(
		id = 3159,
		name = "Find Occurrences of an Element in an Array",
		url = "https://leetcode.com/problems/find-occurrences-of-an-element-in-an-array/description/",
		difficulty = Difficulty.MEDIUM
)
public class FindOccurrencesOfAnElementInAnArray {
	public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
		List<Integer> indices = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == x) {
				indices.add(i);
			}
		}

		int[] ans = new int[queries.length];
		for (int i = 0; i < queries.length; i++) {
			if (queries[i] <= indices.size()) {
				ans[i] = indices.get(queries[i] - 1);
			} else {
				ans[i] = -1;
			}
		}
		return ans;
	}
}