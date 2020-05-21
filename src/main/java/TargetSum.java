import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 21-May-20
 */
@LeetCode(id = 494, name = "Target Sum", url = "https://leetcode.com/problems/target-sum/")
public class TargetSum
{
	public int findTargetSumWays(int[] nums, int S)
	{
		Map<Integer, Map<Integer, Integer>> memo = new HashMap<>();
		return findTargetSumWays(nums, 0, S, memo);
	}

	private int findTargetSumWays(int[] nums, int pos, int S, Map<Integer, Map<Integer, Integer>> memo)
	{
		if (pos == nums.length && S == 0)
		{
			return 1;
		}
		else if (pos == nums.length)
		{
			return 0;
		}

		Map<Integer, Integer> map = memo.getOrDefault(pos, new HashMap<>());
		Integer res = map.get(S);
		if (res != null)
		{
			return res;
		}

		int minus = findTargetSumWays(nums, pos + 1, S - nums[pos], memo);
		int plus = findTargetSumWays(nums, pos + 1, S + nums[pos], memo);
		res = minus + plus;
		map.put(S, res);
		memo.put(pos, map);
		return res;
	}
}
