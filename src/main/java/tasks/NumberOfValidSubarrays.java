package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 2/17/2021
 */
@LeetCode(
	id = 1063,
	name = "Number of Valid Subarrays",
	url = "https://leetcode.com/problems/number-of-valid-subarrays/",
	difficulty = Difficulty.HARD,
	premium = true
)
public class NumberOfValidSubarrays
{
	public int validSubarrays(int[] nums)
	{
		if (nums.length <= 1)
		{
			return nums.length;
		}

		int count = 0;
		Deque<Integer> deque = new LinkedList<>();
		for (int num : nums)
		{
			while (!deque.isEmpty() && deque.peek() > num)
			{
				deque.pop();
			}

			deque.push(num);
			count += deque.size();
		}

		return count;
	}
}
