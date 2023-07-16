package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 8/29/2021
 */
@LeetCode(
		id = 1985,
		name = "Find the Kth Largest Integer in the Array",
		url = "https://leetcode.com/problems/find-the-kth-largest-integer-in-the-array/",
		difficulty = Difficulty.MEDIUM
)
public class FindTheKthLargestIntegerInTheArray
{
	public String kthLargestNumber(String[] nums, int k)
	{
		Arrays.sort(nums, (a, b) ->
		{
			if (a.length() == b.length() && !a.equals(b))
			{
				for (int i = 0; i < a.length(); i++)
				{
					if (a.charAt(i) < b.charAt(i))
					{
						return -1;
					}
					else if (a.charAt(i) > b.charAt(i))
					{
						return 1;
					}
				}
			}

			return a.length() - b.length();
		});

		return nums[nums.length - k];
	}
}
