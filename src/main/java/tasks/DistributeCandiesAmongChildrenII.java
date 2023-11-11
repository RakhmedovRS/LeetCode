package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 11/11/2023
 */
@LeetCode(
		id = 2929,
		name = "Distribute Candies Among Children II",
		url = "https://leetcode.com/problems/distribute-candies-among-children-ii/description/",
		difficulty = Difficulty.MEDIUM
)
public class DistributeCandiesAmongChildrenII
{
	public long distributeCandies(int n, int limit)
	{
		long ans = 0;
		for (int i = 0; i <= Math.min(n, limit); i++)
		{
			int toDistribute = n - i;
			if (toDistribute > limit * 2)
			{
				continue;
			}

			int min = Math.max(0, toDistribute - limit);
			int max = Math.min(toDistribute, limit);
			ans += 1 + max - min;
		}

		return ans;
	}
}
