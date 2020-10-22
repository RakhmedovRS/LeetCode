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
	public int findTargetSumWays(int[] nums, int sum)
	{
		if (nums == null)
		{
			return 0;
		}

		Map<Integer, Integer>[] memo = new HashMap[nums.length + 1];
		return dfs(0, nums, sum, memo);
	}

	private int dfs(int pos, int[] nums, int sum, Map<Integer, Integer>[] memo)
	{
		if (pos == nums.length)
		{
			return sum == 0 ? 1 : 0;
		}

		if (memo[pos] != null && memo[pos].containsKey(sum))
		{
			return memo[pos].get(sum);
		}

		if (memo[pos] == null)
		{
			memo[pos] = new HashMap<>();
		}

		memo[pos].put(sum, dfs(pos + 1, nums, sum - nums[pos], memo) + dfs(pos + 1, nums, sum + nums[pos], memo));
		return memo[pos].get(sum);
	}
}
