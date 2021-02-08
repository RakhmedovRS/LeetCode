import common.Difficulty;
import common.LeetCode;

import java.util.PriorityQueue;

/**
 * @author RakhmedovRS
 * @created 2/8/2021
 */
@LeetCode(
	id = 1753,
	name = "Maximum Score From Removing Stones",
	url = "https://leetcode.com/problems/maximum-score-from-removing-stones/",
	difficulty = Difficulty.MEDIUM
)
public class MaximumScoreFromRemovingStones
{
	public int maximumScore(int a, int b, int c)
	{
		int score = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(a);
		pq.add(b);
		pq.add(c);

		int min;
		int max;
		int temp;
		while (pq.size() > 1)
		{
			min = pq.remove();
			if (pq.size() > 1)
			{
				temp = pq.remove();
				max = pq.remove();
				pq.add(temp);
			}
			else
			{
				max = pq.remove();
			}


			score++;
			if (min - 1 > 0)
			{
				pq.add(min - 1);
			}

			if (max - 1 > 0)
			{
				pq.add(max - 1);
			}
		}

		return score;
	}
}
