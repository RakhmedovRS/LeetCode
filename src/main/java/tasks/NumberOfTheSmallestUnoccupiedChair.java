package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.PriorityQueue;

/**
 * @author RakhmedovRS
 * @created 7/24/2021
 */
@LeetCode(
		id = 1942,
		name = "The Number of the Smallest Unoccupied Chair",
		url = "https://leetcode.com/problems/the-number-of-the-smallest-unoccupied-chair/",
		difficulty = Difficulty.MEDIUM
)
public class NumberOfTheSmallestUnoccupiedChair
{
	public int smallestChair(int[][] times, int targetFriend)
	{
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) ->
		{
			return times[a][0] - times[b][0];
		});

		for (int i = 0; i < times.length; i++)
		{
			pq.add(i);
		}

		PriorityQueue<int[]> occupiedChairs = new PriorityQueue<>((a, b) ->
		{
			return a[0] - b[0];
		});

		PriorityQueue<Integer> emptyChairs = new PriorityQueue<>();

		int maxChair = 0;
		while (!pq.isEmpty())
		{
			int friend = pq.remove();

			while (!occupiedChairs.isEmpty() && occupiedChairs.peek()[0] <= times[friend][0])
			{
				emptyChairs.add(occupiedChairs.remove()[1]);
			}

			if (emptyChairs.isEmpty())
			{
				emptyChairs.add(maxChair++);
			}

			int chair = emptyChairs.remove();
			if (friend == targetFriend)
			{
				return chair;
			}

			occupiedChairs.add(new int[]{times[friend][1], chair});
		}

		return 0;
	}
}
