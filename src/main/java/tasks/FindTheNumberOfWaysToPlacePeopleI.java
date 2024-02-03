package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-02-03
 */
@LeetCode(
		id = 3025,
		name = "Find the Number of Ways to Place People I",
		url = "https://leetcode.com/problems/find-the-number-of-ways-to-place-people-i/",
		difficulty = Difficulty.MEDIUM
)
public class FindTheNumberOfWaysToPlacePeopleI {
	public int numberOfPairs(int[][] points) {
		int ans = 0;
		for (int[] p1 : points) {
			outer:
			for (int[] p2 : points) {
				if (p1[0] == p2[0] && p1[1] == p2[1]) {
					continue;
				}

				if (p1[0] <= p2[0] && p1[1] >= p2[1]) {
					for (int[] p3 : points) {
						if ((p1[0] == p3[0] && p1[1] == p3[1]) || (p2[0] == p3[0] && p2[1] == p3[1])) {
							continue;
						}

						if ((p1[0] <= p3[0] && p1[1] >= p3[1]) && (p3[0] <= p2[0] && p3[1] >= p2[1])) {
							continue outer;
						}
					}

					ans++;
				}
			}
		}

		return ans;
	}
}