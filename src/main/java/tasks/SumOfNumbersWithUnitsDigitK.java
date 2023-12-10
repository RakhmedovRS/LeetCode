package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 6/20/2022
 */
@LeetCode(
		id = 2310,
		name = "Sum of Numbers With Units Digit K",
		url = "https://leetcode.com/problems/sum-of-numbers-with-units-digit-k/",
		difficulty = Difficulty.MEDIUM
)
public class SumOfNumbersWithUnitsDigitK {
	public int minimumNumbers(int num, int k) {
		if (num == 0) {
			return 0;
		}

		List<Integer> digits = new ArrayList<>();
		for (int i = 1; i <= num; i++) {
			if (i % 10 == k) {
				digits.add(i);
			}
		}

		return dfs(num, digits, new HashMap<>());
	}

	private int dfs(int sum, List<Integer> digits, Map<Integer, Integer> memo) {
		if (sum < 0) {
			return -1;
		}

		if (sum == 0) {
			return 0;
		}

		if (memo.containsKey(sum)) {
			return memo.get(sum);
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < digits.size(); i++) {
			int res = dfs(sum - digits.get(i), digits, memo);
			if (res != -1) {
				min = Math.min(min, res + 1);
			}
		}

		min = min == Integer.MAX_VALUE ? -1 : min;

		memo.put(sum, min);

		return min;
	}
}
