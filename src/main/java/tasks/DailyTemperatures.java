package tasks;

import common.LeetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 02-Jul-20
 */
@LeetCode(id = 739, name = "Daily Temperatures", url = "https://leetcode.com/problems/daily-temperatures/")
public class DailyTemperatures
{
	public int[] dailyTemperatures(int[] T)
	{
		int[] answer = new int[T.length];

		Deque<Integer> stack = new LinkedList<>();
		for (int i = 0; i < T.length; i++)
		{
			while (!stack.isEmpty() && T[stack.peek()] < T[i])
			{
				int index = stack.poll();
				answer[index] = i - index;
			}

			stack.push(i);
		}

		return answer;
	}
}
