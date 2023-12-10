package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.List;

/**
 * @author Ruslan Rakhmedov
 * @created 9/16/2023
 */
@LeetCode(
		id = 2861,
		name = "Maximum Number of Alloys",
		url = "https://leetcode.com/problems/maximum-number-of-alloys/",
		difficulty = Difficulty.MEDIUM
)
public class MaximumNumberOfAlloys {
	public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
		int max = 0;
		for (List<Integer> list : composition) {
			int left = 0;
			int right = 1_000_000_000;
			while (left <= right) {
				int mid = (left + right) / 2;
				if (possible(mid, budget, list, stock, cost)) {
					max = Math.max(max, mid);
					left = mid + 1;
				}
				else {
					right = mid - 1;
				}
			}
		}

		return max;
	}

	private boolean possible(long mult, long budget, List<Integer> list, List<Integer> stock, List<Integer> cost) {
		for (int i = 0; i < list.size(); i++) {
			long s = stock.get(i);
			long c = cost.get(i);

			long req = list.get(i) * mult;
			long diff = Math.max(0, req - s);

			budget -= (diff * c);
			if (budget < 0) {
				return false;
			}
		}

		return true;
	}
}
