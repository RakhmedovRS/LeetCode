package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 7/18/2021
 */
@LeetCode(
		id = 1936,
		name = "Add Minimum Number of Rungs",
		url = "https://leetcode.com/problems/add-minimum-number-of-rungs/",
		difficulty = Difficulty.MEDIUM
)
public class AddMinimumNumberOfRungs {
	public int addRungs(int[] rungs, int dist) {
		int adds = 0;
		long current = 0;
		for (int i = 0; i < rungs.length; ) {
			if (Math.max(0, rungs[i] - current) > dist) {
				long add = ((rungs[i] - current) % dist == 0) ? ((rungs[i] - current) / dist - 1) : (rungs[i] - current) / dist;
				adds += add;
				current = rungs[i];
			}
			else {
				current = rungs[i++];
			}
		}

		return adds;
	}
}
