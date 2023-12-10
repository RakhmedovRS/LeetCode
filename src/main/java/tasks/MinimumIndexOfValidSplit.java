package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author Ruslan Rakhmedov
 * @created 7/15/2023
 */
@LeetCode(
		id = 2780,
		name = "Minimum Index of a Valid Split",
		url = "https://leetcode.com/problems/minimum-index-of-a-valid-split/",
		difficulty = Difficulty.MEDIUM
)
public class MinimumIndexOfValidSplit {
	public int minimumIndex(List<Integer> nums) {
		if (nums.size() == 1) {
			return -1;
		}

		int left = 0;
		int right = 1;
		int leftC = 1;
		int rightC = nums.size() - 1;
		Map<Integer, Integer> lMap = new HashMap<>();
		lMap.put(nums.get(0), 1);

		Map<Integer, Integer> rMap = new HashMap<>();
		for (int i = right; i < nums.size(); i++) {
			rMap.put(nums.get(i), rMap.getOrDefault(nums.get(i), 0) + 1);
		}

		TreeSet<Integer> lSet = new TreeSet<>((a, b) -> {
			if (lMap.getOrDefault(a, 0).equals(lMap.getOrDefault(b, 0))) {
				return b - a;
			}

			return lMap.getOrDefault(b, 0) - lMap.getOrDefault(a, 0);
		});
		TreeSet<Integer> rSet = new TreeSet<>((a, b) -> {
			if (rMap.getOrDefault(a, 0).equals(rMap.getOrDefault(b, 0))) {
				return b - a;
			}

			return rMap.getOrDefault(b, 0) - rMap.getOrDefault(a, 0);
		});

		lSet.addAll(lMap.keySet());
		rSet.addAll(rMap.keySet());

		while (right < nums.size()) {
			int lFreq = lMap.get(lSet.first());
			int rFreq = rMap.get(rSet.first());

			if (lFreq * 2 > leftC && rFreq * 2 > rightC && lSet.first().equals(rSet.first())) {
				return left;
			}

			int next = nums.get(right);
			leftC++;
			rightC--;
			left++;
			right++;

			lMap.put(next, lMap.getOrDefault(next, 0) + 1);

			lSet.remove(next);
			lSet.add(next);

			rSet.remove(next);
			int c = rMap.remove(next) - 1;
			if (c > 0) {
				rMap.put(next, c);
				rSet.add(next);
			}
		}

		return -1;
	}
}
