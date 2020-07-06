import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 06-Jul-20
 */
@LeetCode(id = 594, name = "Longest Harmonious Subsequence", url = "https://leetcode.com/problems/longest-harmonious-subsequence/")
public class LongestHarmoniousSubsequence
{
	public int findLHS(int[] nums)
	{
		int max = 0;
		Map<Integer, Integer> numToCount = new HashMap<>();
		for (int num : nums)
		{
			numToCount.put(num, numToCount.getOrDefault(num, 0) + 1);
			if (numToCount.containsKey(num - 1))
			{
				max = Math.max(max, numToCount.get(num) + numToCount.get(num - 1));
			}

			if (numToCount.containsKey(num + 1))
			{
				max = Math.max(max, numToCount.get(num) + numToCount.get(num + 1));
			}
		}

		return max;
	}
}
