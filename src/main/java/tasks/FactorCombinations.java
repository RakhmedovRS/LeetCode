package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 1/11/2021
 */
@LeetCode(
		id = 254,
		name = "Factor Combinations",
		url = "https://leetcode.com/problems/factor-combinations/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class FactorCombinations {
	public List<List<Integer>> getFactors(int n) {
		return dfs(n, n);
	}

	private List<List<Integer>> dfs(int n, int start) {
		if (n == 1) {
			return Collections.emptyList();
		}

		List<List<Integer>> answer = new ArrayList<>();
		List<List<Integer>> nexts;
		for (int i = 2; i <= n; i++) {
			if (n % i == 0) {
				nexts = dfs(n / i, start);
				for (List<Integer> next : nexts) {
					if (next.isEmpty() || i > next.get(0)) {
						continue;
					}

					List<Integer> list = new ArrayList<>();
					list.add(i);
					list.addAll(next);
					answer.add(list);
				}
			}
		}

		if (n != start) {
			answer.add(Arrays.asList(n));
		}

		return answer;
	}
}
