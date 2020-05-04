import common.LeetCode;

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
		if (nums == null || nums.length <= 1 || k < 0)
		{
			return 0;
		}

		int pairs = 0;
		Map<Long, Integer> memo = new HashMap<>();
		for (int i = 0; i < nums.length; i++)
		{
			memo.put((long) nums[i], memo.getOrDefault((long) nums[i], 0) + 1);
		}

		if (k == 0)
		{
			for (Integer value : memo.values())
			{
				if (value >= 2)
				{
					pairs++;
				}
			}
		}
		else
		{
			for (int i = nums.length - 1; i >= 0; i--)
			{
				Long target = ((long) nums[i]) + k;
				if (memo.containsKey(target))
				{
					pairs++;
					memo.remove(target);
				}
			}
		}

		return pairs;
	}

	public static void main(String[] args)
	{
		System.out.println(new KdiffPairsInArray().findPairs(new int[]{1, 2, 3, 4, 5}, -1));
		System.out.println(new KdiffPairsInArray().findPairs(new int[]{1, 2, 3, 4, 5}, 4));
		System.out.println(new KdiffPairsInArray().findPairs(new int[]{1, 3, 1, 5, 4}, 0));
		System.out.println(new KdiffPairsInArray().findPairs(new int[]{3, 1, 4, 1, 5}, 2));
		System.out.println(new KdiffPairsInArray().findPairs(new int[]{1, 2, 3, 4, 5}, 1));
	}
}
