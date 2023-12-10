package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ruslan Rakhmedov
 * @created 11/11/2023
 */
@LeetCode(
		id = 2928,
		name = "Distribute Candies Among Children I",
		url = "https://leetcode.com/problems/distribute-candies-among-children-i/description/",
		difficulty = Difficulty.EASY
)
public class DistributeCandiesAmongChildrenI {
	public int distributeCandies(int n, int limit) {
		Set<Integer> set = new HashSet<>();
		int[] kids = new int[]{0, 0, 0};
		for (int a = 0; a <= n; a++) {
			if (a > limit) {
				break;
			}
			for (int b = 0; b <= n; b++) {
				if (b > limit) {
					break;
				}

				for (int c = 0; c <= n; c++) {
					if (c > limit) {
						break;
					}

					if (a + b + c == n) {
						set.add(a * 100000 + b * 1000 + c);
					}
				}
			}
		}

		return set.size();
	}
}
