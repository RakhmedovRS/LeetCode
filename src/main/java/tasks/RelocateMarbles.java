package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Ruslan Rakhmedov
 * @created 7/8/2023
 */
@LeetCode(
		id = 2766,
		name = "Relocate Marbles",
		url = "https://leetcode.com/problems/relocate-marbles/",
		difficulty = Difficulty.MEDIUM
)
public class RelocateMarbles {
	public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
		Set<Integer> set = new HashSet<>();
		for (int num : nums) {
			set.add(num);
		}

		for (int i = 0; i < moveTo.length; i++) {
			set.remove(moveFrom[i]);
			set.add(moveTo[i]);
		}

		List<Integer> keys = new ArrayList<>(set);
		keys.sort(null);
		return keys;
	}
}
