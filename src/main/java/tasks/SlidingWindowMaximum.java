package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 13-Apr-20
 */
@LeetCode(
		id = 239,
		name = "Sliding Window Maximum",
		url = "https://leetcode.com/problems/sliding-window-maximum/",
		difficulty = Difficulty.HARD
)
public class SlidingWindowMaximum
{
	public int[] maxSlidingWindow(int[] nums, int k)
	{
		int left = 0;
		int right = 0;
		int[] answer = new int[nums.length - (k - 1)];
		int pos = 0;
		LinkedList<Integer> linkedList = new LinkedList<>();
		while (right < nums.length)
		{
			while (!linkedList.isEmpty() && linkedList.getLast() < nums[right])
			{
				linkedList.removeLast();
			}

			linkedList.addLast(nums[right++]);

			if (right - left == k)
			{
				answer[pos++] = linkedList.getFirst();
			}
			else if (right - left > k)
			{
				if (linkedList.getFirst() == nums[left++])
				{
					linkedList.removeFirst();
				}
				answer[pos++] = linkedList.getFirst();
			}
		}

		return answer;
	}
}
