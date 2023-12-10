package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 10/21/2020
 */
@LeetCode(
		id = 869,
		name = "Reordered Power of 2",
		url = "https://leetcode.com/problems/reordered-power-of-2/",
		difficulty = Difficulty.MEDIUM
)
public class ReorderedPowerOf2 {
	public boolean reorderedPowerOf2(int N) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < 31; i++) {
			set.add((int) Math.pow(2, i));
		}

		if (set.contains(N)) {
			return true;
		}

		int[] digits = new int[10];
		while (N > 0) {
			digits[N % 10]++;
			N /= 10;
		}

		return dfs(0, digits, set);
	}

	private boolean dfs(int num, int[] digits, Set<Integer> set) {
		boolean found = false;
		for (int i = num > 0 ? 0 : 1; i < digits.length; i++) {
			if (digits[i] > 0) {
				found = true;
				digits[i]--;
				if (dfs(num * 10 + i, digits, set)) {
					return true;
				}
				digits[i]++;
			}
		}

		if (!found) {
			return set.contains(num);
		}

		return false;
	}
}
