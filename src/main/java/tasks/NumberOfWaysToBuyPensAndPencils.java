package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 4/16/2022
 */
@LeetCode(
		id = 2240,
		name = "Number of Ways to Buy Pens and Pencils",
		url = "https://leetcode.com/problems/number-of-ways-to-buy-pens-and-pencils/",
		difficulty = Difficulty.MEDIUM
)
public class NumberOfWaysToBuyPensAndPencils {
	public long waysToBuyPensPencils(int total, int cost1, int cost2) {
		if (total < cost1 && total < cost2) {
			return 1;
		}

		long answer = 0;
		while (true) {
			answer += total / cost2 + 1;
			total -= cost1;
			if (total < 0) {
				break;
			}
		}

		return answer;
	}
}
