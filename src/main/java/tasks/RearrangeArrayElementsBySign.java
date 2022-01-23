package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 1/23/2022
 */
@LeetCode(
	id = 2149,
	name = "Rearrange Array Elements by Sign",
	url = "https://leetcode.com/problems/rearrange-array-elements-by-sign/",
	difficulty = Difficulty.MEDIUM
)
public class RearrangeArrayElementsBySign
{
	public int[] rearrangeArray(int[] nums)
	{
		LinkedList<Integer> positive = new LinkedList<>();
		LinkedList<Integer> negative = new LinkedList<>();
		for (int num : nums)
		{
			if (num < 0)
			{
				negative.addLast(num);
			}
			else
			{
				positive.addLast(num);
			}
		}

		for (int i = 0; i < nums.length; i++)
		{
			if (i % 2 == 0)
			{
				nums[i] = positive.removeFirst();
			}
			else
			{
				nums[i] = negative.removeFirst();
			}
		}

		return nums;
	}
}
