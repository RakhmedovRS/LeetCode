package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 5/16/2021
 */
@LeetCode(
		id = 1865,
		name = "Finding Pairs With a Certain Sum",
		url = "https://leetcode.com/problems/finding-pairs-with-a-certain-sum/",
		difficulty = Difficulty.MEDIUM
)
public class FindingPairsWithCertainSum
{
	class FindSumPairs
	{

		int[] nums1;
		int[] nums2;
		Map<Integer, Integer> numToCount;

		public FindSumPairs(int[] nums1, int[] nums2)
		{
			this.nums1 = nums1;
			this.nums2 = nums2;
			numToCount = new HashMap<>();

			for (int num : nums2)
			{
				numToCount.put(num, numToCount.getOrDefault(num, 0) + 1);
			}

			Arrays.sort(nums1);
		}

		public void add(int index, int val)
		{
			numToCount.put(nums2[index], numToCount.get(nums2[index]) - 1);
			nums2[index] += val;
			numToCount.put(nums2[index], numToCount.getOrDefault(nums2[index], 0) + 1);
		}

		public int count(int tot)
		{
			int count = 0;
			for (int num : nums1)
			{
				if (num > tot)
				{
					break;
				}

				count += numToCount.getOrDefault(tot - num, 0);
			}

			return count;
		}
	}
}
