import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 09-Aug-20
 */
@LeetCode(id = 1546, name = "Maximum Number of Non-Overlapping Subarrays With Sum Equals Target", url = "https://leetcode.com/problems/maximum-number-of-non-overlapping-subarrays-with-sum-equals-target/")
public class MaximumNumberOfNonOverlappingSubarraysWithSumEqualsTarget
{
	public int maxNonOverlapping(int[] nums, int target)
	{
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 0);

		int res = 0;
		int sum = 0;

		for (int num : nums)
		{
			sum += num;
			if (map.containsKey(sum - target))
			{
				res = Math.max(res, map.get(sum - target) + 1);
			}
			map.put(sum, res);
		}

		return res;
	}

	public static void main(String[] args)
	{
		System.out.println(new MaximumNumberOfNonOverlappingSubarraysWithSumEqualsTarget().maxNonOverlapping(new int[]{1, 3, 2, -1, 3, 1, 0, 0, 3, 1, 0, 3, 2, 1, 3, -1, 1, -1, 3, 3, 0, 3, 1, 0, 3, -1, 0, 2, 2, -1, 0}, 4)); //0
		System.out.println(new MaximumNumberOfNonOverlappingSubarraysWithSumEqualsTarget().maxNonOverlapping(new int[]{1, 2, 3, 4}, 8)); //0
		System.out.println(new MaximumNumberOfNonOverlappingSubarraysWithSumEqualsTarget().maxNonOverlapping(new int[]{-2, 6, 6, 3, 5, 4, 1, 2, 8}, 10)); //3
		System.out.println(new MaximumNumberOfNonOverlappingSubarraysWithSumEqualsTarget().maxNonOverlapping(new int[]{1, 2, 3, 4}, 8)); //0
		System.out.println(new MaximumNumberOfNonOverlappingSubarraysWithSumEqualsTarget().maxNonOverlapping(new int[]{0, 0, 0}, 0)); //3
		System.out.println(new MaximumNumberOfNonOverlappingSubarraysWithSumEqualsTarget().maxNonOverlapping(new int[]{-1, 3, 5, 1, 4, 2, -9}, 6)); //2
		System.out.println(new MaximumNumberOfNonOverlappingSubarraysWithSumEqualsTarget().maxNonOverlapping(new int[]{1, 1, 1, 1, 1}, 2)); //2
	}
}
