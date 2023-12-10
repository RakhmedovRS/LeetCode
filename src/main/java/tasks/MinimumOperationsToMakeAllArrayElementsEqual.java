package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 3/28/2023
 */
@LeetCode(
		id = 2602,
		name = "Minimum Operations to Make All Array Elements Equal",
		url = "https://leetcode.com/problems/minimum-operations-to-make-all-array-elements-equal/",
		difficulty = Difficulty.MEDIUM
)
public class MinimumOperationsToMakeAllArrayElementsEqual {
	public List<Long> minOperations(int[] nums, int[] queries) {
		Arrays.sort(nums);
		TreeMap<Integer, Long> leftToRight = new TreeMap<>();
		TreeMap<Integer, Long> rightToLeft = new TreeMap<>();

		long sum = 0;
		for (int num : nums) {
			sum += num;
			leftToRight.put(num, sum);
		}

		sum = 0;
		for (int i = nums.length - 1; i >= 0; i--) {
			int num = nums[i];
			sum += num;
			rightToLeft.put(num, sum);
		}


		List<Long> res = new ArrayList<>();
		for (int query : queries) {
			long val = 0;

			Map.Entry<Integer, Long> left = leftToRight.floorEntry(leftToRight.containsKey(query) ? query - 1 : query);
			Map.Entry<Integer, Long> right = rightToLeft.ceilingEntry(leftToRight.containsKey(query) ? query + 1 : query);
			if (left != null) {

//                long count = leftToRight.headMap(leftToRight.containsKey(query) ? query - 1 : query).size();
				long count = findSmaller(nums, query) + 1;
				val += (count * query) - left.getValue();
			}

			if (right != null) {
				//long count = rightToLeft.tailMap(leftToRight.containsKey(query) ? query + 1 : query).size();
				long count = nums.length - findBigger(nums, query);
				val += right.getValue() - (count * query);
			}

			res.add(val);
		}

		return res;
	}

	private int findSmaller(int[] nums, int val) {
		int left = 0;
		int right = nums.length - 1;
		int mid;
		int candidate = nums.length - 1;
		while (left <= right) {
			mid = (right - left) / 2 + left;
			if (nums[mid] >= val) {
				candidate = mid - 1;
				right = mid - 1;
			}
			else {
				left = mid + 1;
			}
		}

		return candidate;
	}

	private int findBigger(int[] nums, int val) {
		int left = 0;
		int right = nums.length - 1;
		int mid;
		int candidate = 0;
		while (left <= right) {
			mid = (right - left) / 2 + left;
			if (nums[mid] <= val) {
				candidate = mid + 1;
				left = mid + 1;
			}
			else {
				right = mid - 1;
			}
		}

		return candidate;
	}
}
