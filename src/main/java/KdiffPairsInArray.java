import common.LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 09-Apr-20
 */
@LeetCode(id = 532, name = "K-diff Pairs in an Array", url = "https://leetcode.com/problems/k-diff-pairs-in-an-array/")
public class KdiffPairsInArray
{
	public int findPairs(int[] nums, int k)
	{
		if (nums == null || nums.length <= 1)
		{
			return 0;
		}

		Arrays.sort(nums);
		Map<Integer, Integer> memo = new HashMap<>();
		for (int i = 0; i < nums.length - 1; i++)
		{
			for (int j = i + 1; j < nums.length; j++)
			{
				if (Math.abs(nums[i] - nums[j]) == k)
				{
					Integer J = memo.get(nums[i]);
					if (J == null || J != nums[j])
					{
						memo.put(nums[i], nums[j]);
					}
				}
			}
		}

		return memo.values().size();
	}
}
