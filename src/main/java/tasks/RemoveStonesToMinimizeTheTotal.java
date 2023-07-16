package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author RakhmedovRS
 * @created 8/8/2021
 */
@LeetCode(
		id = 1962,
		name = "Remove Stones to Minimize the Total",
		url = "https://leetcode.com/problems/remove-stones-to-minimize-the-total/",
		difficulty = Difficulty.MEDIUM
)
public class RemoveStonesToMinimizeTheTotal
{
	public int minStoneSum(int[] piles, int k)
	{
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		for (int pile : piles)
		{
			pq.add(pile);
		}

		for (int i = 0; i < k; i++)
		{
			pq.add(pq.peek() % 2 == 0 ? pq.remove() / 2 : (pq.remove() / 2) + 1);
		}

		int sum = 0;
		while (!pq.isEmpty())
		{
			sum += pq.remove();
		}
		return sum;
	}
}
