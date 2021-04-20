package tasks;

import common.LeetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 02-Aug-20
 */
@LeetCode(id = 1535, name = "Find the Winner of an Array Game", url = "https://leetcode.com/problems/find-the-winner-of-an-array-game/")
public class FindTheWinnerOfArrayGame
{
	public int getWinner(int[] arr, int k)
	{
		Deque<Integer> queue = new LinkedList<>();
		int max = 0;
		for (int num : arr)
		{
			queue.add(num);
			max = Math.max(max, num);
		}

		int winner = 0;
		int winsCount = 0;
		while (!queue.isEmpty())
		{
			int a = queue.poll();
			if (a == max)
			{
				return max;
			}
			int b = queue.poll();
			if (a > b)
			{
				if (winner == a)
				{
					winsCount++;
				}
				else
				{
					winner = a;
					winsCount = 1;
				}
				queue.addFirst(a);
				queue.addLast(b);
			}
			else
			{
				if (winner == b)
				{
					winsCount++;
				}
				else
				{
					winner = b;
					winsCount = 1;
				}
				queue.addFirst(b);
				queue.addLast(a);
			}
			if (winsCount == k)
			{
				break;
			}
		}

		return winner;
	}
}
