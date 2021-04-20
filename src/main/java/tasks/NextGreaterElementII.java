package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 09-Sep-20
 */
@LeetCode(
	id = 503,
	name = "Next Greater Element II",
	url = "https://leetcode.com/problems/next-greater-element-ii/",
	difficulty = Difficulty.MEDIUM
)
public class NextGreaterElementII
{
	public int[] nextGreaterElements(int[] nums)
	{
		int[] answer = new int[nums.length];
		Arrays.fill(answer, - 1);
		LinkedList<Integer> integers = new LinkedList<>();
		for (int i = 0; i < nums.length * 2; i++)
		{
			while (!integers.isEmpty()
				&& nums[integers.getFirst() % nums.length] < nums[i % nums.length])
			{
				if (integers.getFirst() < nums.length)
				{
					answer[integers.removeFirst()] = nums[i % nums.length];
				}
				else
				{
					integers.removeFirst();
				}
			}

			integers.addFirst(i);
		}

		return answer;
	}
}
