package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 1/30/2022
 */
@LeetCode(
		id = 2154,
		name = "Keep Multiplying Found Values by Two",
		url = "https://leetcode.com/problems/keep-multiplying-found-values-by-two/",
		difficulty = Difficulty.EASY
)
public class KeepMultiplyingFoundValuesByTwo {
	public int findFinalValue(int[] nums, int original) {
		Set<Integer> vals = new HashSet<>();
		for (int num : nums) {
			vals.add(num);
		}

		while (vals.contains(original)) {
			original *= 2;
		}

		return original;
	}
}
