package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author RakhmedovRS
 * @created 1/22/2022
 */
@LeetCode(
		id = 2144,
		name = "Minimum Cost of Buying Candies With Discount",
		url = "https://leetcode.com/problems/minimum-cost-of-buying-candies-with-discount/",
		difficulty = Difficulty.EASY
)
public class MinimumCostOfBuyingCandiesWithDiscount {
	public int minimumCost(int[] cost) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		for (int c : cost) {
			pq.add(c);
		}

		int result = 0;
		int num = 0;
		while (!pq.isEmpty()) {
			num++;
			if (num % 3 == 0) {
				pq.remove();
			}
			else {
				result += pq.remove();
			}

			num %= 3;
		}

		return result;
	}
}
