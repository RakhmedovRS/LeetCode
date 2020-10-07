import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 10/7/2020
 */
@LeetCode(id = 930, name = "Binary Subarrays With Sum", url = "https://leetcode.com/problems/binary-subarrays-with-sum/")
public class BinarySubarraysWithSum
{
	public int numSubarraysWithSum(int[] A, int targetSum)
	{
		int count = 0;
		int sum = 0;
		Map<Integer, Integer> memo = new HashMap<>();
		memo.put(0, 1);
		for (int val : A)
		{
			sum += val;
			if (sum >= targetSum)
			{
				count += memo.getOrDefault(sum - targetSum, 0);
			}
			memo.put(sum, memo.getOrDefault(sum, 0) + 1);
		}

		return count;
	}
}
