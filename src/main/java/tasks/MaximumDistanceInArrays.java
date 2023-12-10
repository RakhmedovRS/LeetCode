package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.List;

/**
 * @author RakhmedovRS
 * @created 12/7/2020
 */
@LeetCode(
		id = 624,
		name = "Maximum Distance in Arrays",
		url = "https://leetcode.com/problems/maximum-distance-in-arrays/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class MaximumDistanceInArrays {
	public int maxDistance(List<List<Integer>> arrays) {
		int max = 0;
		int globalMin = arrays.get(0).get(0);
		int globalMax = arrays.get(0).get(arrays.get(0).size() - 1);
		int first;
		int last;
		for (int i = 1; i < arrays.size(); i++) {
			first = arrays.get(i).get(0);
			last = arrays.get(i).get(arrays.get(i).size() - 1);

			max = Math.max(max, Math.abs(globalMax - first));
			max = Math.max(max, Math.abs(last - globalMin));

			globalMin = Math.min(globalMin, first);
			globalMax = Math.max(globalMax, last);
		}

		return max;
	}
}
