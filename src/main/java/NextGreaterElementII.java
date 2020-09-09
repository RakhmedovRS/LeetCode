import common.LeetCode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 09-Sep-20
 */
@LeetCode(id = 503, name = "Next Greater Element II", url = "https://leetcode.com/problems/next-greater-element-ii/")
public class NextGreaterElementII
{
	public int[] nextGreaterElements(int[] nums)
	{
		int n = nums.length;
		int[] answer = new int[nums.length];
		Arrays.fill(answer, -1);
		Deque<Integer> deque = new LinkedList<>();
		for (int i = 0; i < nums.length * 2; i++)
		{
			while (!deque.isEmpty() && nums[deque.peek()] < nums[i % n])
			{
				answer[deque.pop()] = nums[i % n];
			}
			deque.push(i % n);
		}

		return answer;
	}
}
