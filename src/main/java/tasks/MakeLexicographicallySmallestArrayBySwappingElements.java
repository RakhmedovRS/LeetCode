package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author Ruslan Rakhmedov
 * @created 11/26/2023
 */
@LeetCode(
		id = 2948,
		name = "Make Lexicographically Smallest Array by Swapping Elements",
		url = "https://leetcode.com/problems/make-lexicographically-smallest-array-by-swapping-elements/",
		difficulty = Difficulty.MEDIUM
)
public class MakeLexicographicallySmallestArrayBySwappingElements {
	public int[] lexicographicallySmallestArray(int[] nums, int limit) {
		int[] copy = Arrays.copyOf(nums, nums.length);
		Arrays.sort(copy);
		Map<Integer, LinkedList<Integer>> subGroups = new HashMap<>((int) (nums.length * 1.4D));
		for (int i = 0; i < copy.length; i++) {
			LinkedList<Integer> subGroup = new LinkedList<>();
			subGroup.add(copy[i]);
			subGroups.put(copy[i], subGroup);
			int prev = copy[i];
			for (int j = i + 1; j < nums.length; j++) {
				if (copy[j] - prev <= limit) {
					subGroup.add(copy[j]);
					i = j;
					prev = copy[j];
					subGroups.put(copy[j], subGroup);
				}
				else {
					break;
				}
			}
		}

		for (int i = 0; i < nums.length; i++) {
			LinkedList<Integer> list = subGroups.get(nums[i]);
			nums[i] = list.removeFirst();
		}

		return nums;
	}
}
