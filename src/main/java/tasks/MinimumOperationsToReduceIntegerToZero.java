package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ruslan Rakhmedov
 * @created 2/23/2023
 */
@LeetCode(
		id = 2571,
		name = "Minimum Operations to Reduce an Integer to 0",
		url = "https://leetcode.com/problems/minimum-operations-to-reduce-an-integer-to-0/",
		difficulty = Difficulty.MEDIUM
)
public class MinimumOperationsToReduceIntegerToZero {
	public int minOperations(int n) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i <= 30; i++) {
			list.add((int) Math.pow(2, i));
		}

		int prev = 0;
		int next = 0;
		for (int num : list) {
			if (n >= num) {
				prev = num / 2;
			}
			else {
				next = num * 2;
				break;
			}
		}

		Map<Integer, Integer> memo = new HashMap<>();
		int res = minOperations(n, list, memo);
		for (int i = prev; i <= n; i++) {
			res = Math.min(res, minOperations(n - i, list, memo) + minOperations(i, list, memo));
		}

		for (int i = n; i <= next; i++) {
			res = Math.min(res, minOperations(i - n, list, memo) + minOperations(i, list, memo));
		}

		return res;
	}

	public int minOperations(int n, List<Integer> list, Map<Integer, Integer> memo) {
		if (memo.containsKey(n)) {
			return memo.get(n);
		}

		int origin = n;
		int steps = 0;
		outer:
		while (n > 0) {
			for (int i = list.size() - 1; i >= 0; i--) {
				if (n >= list.get(i)) {
					n -= list.get(i);
					steps++;
				}
			}
		}

		memo.put(origin, steps);

		return steps;
	}
}
