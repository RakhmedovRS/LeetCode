package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.PriorityQueue;

/**
 * @author RakhmedovRS
 * @created 3/5/2022
 */
@LeetCode(
	id = 2191,
	name = "Sort the Jumbled Numbers",
	url = "https://leetcode.com/contest/biweekly-contest-73/problems/sort-the-jumbled-numbers/",
	difficulty = Difficulty.MEDIUM
)
public class SortTheJumbledNumbers
{
	public int[] sortJumbled(int[] mapping, int[] nums)
	{
		int[] memo = new int[nums.length];
		for (int i = 0; i < nums.length; i++)
		{
			StringBuilder sb = new StringBuilder();
			int num = nums[i];
			if (num == 0)
			{
				sb.append(mapping[num]);
			}
			else
			{
				while (num > 0)
				{
					sb.append(mapping[num % 10]);
					num /= 10;
				}
			}

			memo[i] = Integer.parseInt(sb.reverse().toString());
		}

		PriorityQueue<Integer> pqq = new PriorityQueue<>((i, j) ->
		{
			if (memo[i] == memo[j])
			{
				return i - j;
			}

			return memo[i] - memo[j];
		});

		for (int i = 0; i < nums.length; i++)
		{
			pqq.add(i);
		}

		int[] answer = new int[nums.length];
		for (int i = 0; i < nums.length; i++)
		{
			answer[i] = nums[pqq.remove()];
		}

		return answer;
	}
}
