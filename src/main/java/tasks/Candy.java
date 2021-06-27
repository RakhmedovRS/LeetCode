package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author RakhmedovRS
 * @created 08-Mar-20
 */
@LeetCode(
	id = 135,
	name = "Candy",
	url = "https://leetcode.com/problems/candy/",
	difficulty = Difficulty.HARD)
public class Candy
{
	public int candy(int[] ratings)
	{
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(a -> ratings[a]));
		for (int i = 0; i < ratings.length; i++)
		{
			pq.add(i);
		}

		int[] candies = new int[ratings.length];
		Arrays.fill(candies, 1);

		while (!pq.isEmpty())
		{
			int pos = pq.remove();

			if (pos - 1 >= 0)
			{
				if (ratings[pos - 1] < ratings[pos])
				{
					candies[pos] = Math.max(candies[pos], candies[pos - 1] + 1);
				}
			}

			if (pos + 1 < ratings.length)
			{
				if (ratings[pos + 1] < ratings[pos])
				{
					candies[pos] = Math.max(candies[pos], candies[pos + 1] + 1);
				}
			}
		}

		int count = 0;
		for (int candy : candies)
		{
			count += candy;
		}
		return count;
	}

	public static void main(String[] args)
	{
		System.out.println(new Candy().candy(new int[]{1, 2, 2}));
	}
}
