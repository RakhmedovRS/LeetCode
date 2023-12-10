package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 06-Aug-20
 */
@LeetCode(
		id = 458,
		name = "Poor Pigs",
		url = "https://leetcode.com/problems/poor-pigs/",
		difficulty = Difficulty.HARD
)
public class PoorPigs {
	public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
		int pigs = 0;
		while (Math.pow(minutesToTest / minutesToDie + 1, pigs) < buckets) {
			pigs++;
		}

		return pigs;
	}
}
