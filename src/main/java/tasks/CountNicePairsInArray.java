package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ruslan Rakhmedov
 * @created 11/20/2023
 */
@LeetCode(
		id = 1814,
		name = "Count Nice Pairs in an Array",
		url = "https://leetcode.com/problems/count-nice-pairs-in-an-array/",
		difficulty = Difficulty.MEDIUM
)
public class CountNicePairsInArray
{
	public int countNicePairs(int[] nums)
	{
		Map<Integer, Integer> map = new HashMap<>();
		int ans = 0;
		for (int num : nums)
		{
			int res = num - reverse(num);
			ans = (ans + map.getOrDefault(res, 0)) % 1_000_000_007;
			map.put(res, map.getOrDefault(res, 0) + 1);
		}

		return ans;
	}

	private int reverse(int num)
	{
		int res = 0;
		while (num > 0)
		{
			res *= 10;
			res += num % 10;
			num /= 10;
		}
		return res;
	}
}
