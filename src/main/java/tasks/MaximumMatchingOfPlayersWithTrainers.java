package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.PriorityQueue;

/**
 * @author Ruslan Rakhmedov
 * @created 9/20/2022
 */
@LeetCode(
		id = 2410,
		name = "Maximum Matching of Players With Trainers",
		url = "https://leetcode.com/problems/maximum-matching-of-players-with-trainers/",
		difficulty = Difficulty.MEDIUM
)
public class MaximumMatchingOfPlayersWithTrainers
{
	public int matchPlayersAndTrainers(int[] players, int[] trainers)
	{
		PriorityQueue<Integer> p = new PriorityQueue<>();
		for (int player : players)
		{
			p.add(player);
		}

		PriorityQueue<Integer> t = new PriorityQueue<>();
		for (int trainer : trainers)
		{
			t.add(trainer);
		}


		int match = 0;
		while (!p.isEmpty() && !t.isEmpty())
		{
			if (p.peek() <= t.peek())
			{
				match++;
				p.remove();
				t.remove();
			}
			else
			{
				t.remove();
			}
		}

		return match;
	}
}
