package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.TreeSet;

/**
 * @author Ruslan Rakhmedov
 * @created 12/30/2022
 */
@LeetCode(
		id = 2517,
		name = "Maximum Tastiness of Candy Basket",
		url = "https://leetcode.com/problems/maximum-tastiness-of-candy-basket/",
		difficulty = Difficulty.MEDIUM
)
public class MaximumTastinessOfCandyBasket {
	public int maximumTastiness(int[] prices, int k) {
		TreeSet<Long> treeSet = new TreeSet<>();
		for (long price : prices) {
			treeSet.add(price);
		}

		int min = 0;
		long left = 0;
		long right = Integer.MAX_VALUE;
		long mid;
		outer:
		while (left <= right) {
			mid = (left + right) / 2;
			Long val = treeSet.last();
			for (int i = 0; i < k - 1; i++) {
				val = treeSet.floor(val - mid);
				if (val == null) {
					right = mid - 1;
					continue outer;
				}
			}
			min = Math.max(min, (int) mid);

			left = mid + 1;
		}

		return min;
	}
}
