package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ruslan Rakhmedov
 * @created 8/8/2022
 * @Ruslan Rakhmedov$
 * @1.0$
 */
@LeetCode(
		id = 2364,
		name = "Count Number of Bad Pairs",
		url = "https://leetcode.com/problems/count-number-of-bad-pairs/",
		difficulty = Difficulty.MEDIUM
)
public class CountNumberOfBadPairs
{
	public long countBadPairs(int[] nums)
	{
		long answer = 0;
		Map<Integer, Long> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++)
		{
			int res = i - nums[i];
			answer += i;
			answer -= map.getOrDefault(res, 0L);
			map.put(res, map.getOrDefault(res, 0L) + 1);
		}

		return answer;
	}
}
