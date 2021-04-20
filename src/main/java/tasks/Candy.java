package tasks;

import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 08-Mar-20
 */
@LeetCode(id = 135, name = "tasks.Candy", url = "https://leetcode.com/problems/candy/")
public class Candy
{
	public int candy(int[] ratings)
	{
		int[] memo = new int[ratings.length];
		Arrays.fill(memo, 1);

		for (int i = 1; i < ratings.length - 2; i++)
		{
			int l = 0;
			int r = 0;

			if (ratings[i] > ratings[i - 1])
			{
				l = memo[i - 1];
			}

			if (ratings[i] > ratings[i + 1])
			{
				r = memo[i + 1];
			}

			memo[i] = Math.max(l, r) + 1;
		}

		for (int i = 1; i < ratings.length; i++)
		{
			if (ratings[i] > ratings[i - 1] && memo[i] <= memo[i - 1])
			{
				memo[i] = memo[i - 1] + 1;
			}
		}

		for (int i = ratings.length - 2; i >= 0; i--)
		{
			if (ratings[i] > ratings[i + 1] && memo[i] <= memo[i + 1])
			{
				memo[i] = memo[i + 1] + 1;
			}
		}

		return Arrays.stream(memo).sum();
	}

	public static void main(String[] args)
	{
		System.out.println(new Candy().candy(new int[]{1, 2, 2}));
	}
}
