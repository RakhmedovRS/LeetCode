package tasks;

import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 02-Aug-20
 */
@LeetCode(id = 1537, name = "Get the Maximum Score", url = "https://leetcode.com/problems/get-the-maximum-score/")
public class GetTheMaximumScore
{
	public int maxSum(int[] nums1, int[] nums2)
	{
		int mod = (int) (Math.pow(10, 9)) + 7;
		Map<Integer, Long> map1 = new HashMap<>();
		map1.put(0, 0L);
		Map<Integer, Long> map2 = new HashMap<>();
		map2.put(0, 0L);

		long sum = 0;
		for (int num : nums1)
		{
			sum += num;
			map1.put(num, sum);
		}

		sum = 0;
		for (int num : nums2)
		{
			sum += num;
			map2.put(num, sum);
		}

		int prev = 0;
		long answer = 0;
		for (int curr : nums1)
		{
			if (map2.containsKey(curr))
			{
				answer += Math.max(map1.get(curr) - map1.get(prev), map2.get(curr) - map2.get(prev));
				prev = curr;
			}
		}

		answer += Math.max(map1.get(nums1[nums1.length - 1]) - map1.get(prev),
			map2.get(nums2[nums2.length - 1]) - map2.get(prev));

		return (int) (answer % mod);
	}
}
