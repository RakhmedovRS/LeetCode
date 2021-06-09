package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 12/20/2020
 */
@LeetCode(
	id = 1696,
	name = "Jump Game VI",
	url = "https://leetcode.com/problems/jump-game-vi/",
	difficulty = Difficulty.MEDIUM
)
public class JumpGameVI
{
	public int maxResult(int[] nums, int k)
	{
		int[] dp = new int[nums.length];
		dp[0] = nums[0];

		LinkedList<Integer> deque = new LinkedList<>();
		deque.add(0);
		for (int i = 1; i < nums.length; i++)
		{
			while (deque.getFirst() < i - k)
			{
				deque.removeFirst();
			}

			dp[i] = nums[i] + dp[deque.getFirst()];
			while (!deque.isEmpty() && dp[deque.getLast()] <= dp[i])
			{
				deque.removeLast();
			}

			deque.addLast(i);
		}

		return dp[dp.length - 1];
	}

	public static void main(String[] args)
	{
		JumpGameVI clazz = new JumpGameVI();
		System.out.println(clazz.maxResult(new int[]{100, -1, -100, -1, 100}, 2));
		System.out.println(clazz.maxResult(new int[]{1, -5, -20, 4, -1, 3, -6, -3}, 2));
		System.out.println(clazz.maxResult(new int[]{1, -1, -2, 4, -7, 3}, 2));
		System.out.println(clazz.maxResult(new int[]{10, -5, -2, 4, 0, 3}, 3));
	}
}
