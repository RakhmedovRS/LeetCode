import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 12/6/2020
 */
@LeetCode(
	id = 1679,
	name = "Max Number of K-Sum Pairs",
	url = "https://leetcode.com/problems/max-number-of-k-sum-pairs/",
	difficulty = Difficulty.MEDIUM
)
public class MaxNumberOfKSumPairs
{
	public int maxOperations(int[] nums, int k)
	{
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums)
		{
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		int ops = 0;
		int c1;
		int c2;
		for (int num : nums)
		{
			c1 = map.get(num);
			c2 = map.getOrDefault(k - num, 0);
			if (k - num == num)
			{
				if (c1 > 1)
				{
					ops += c1 / 2;
					map.put(num, c1 % 2);
				}
			}
			else
			{
				if (c1 > 0 && c2 > 0)
				{
					ops++;

					map.put(num, c1 - 1);
					map.put(k - num, c2 - 1);
				}
			}
		}

		return ops;
	}
}
