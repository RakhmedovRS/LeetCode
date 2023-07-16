package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author RakhmedovRS
 * @created 4/17/2022
 */
@LeetCode(
		id = 2244,
		name = "Minimum Rounds to Complete All Tasks",
		url = "https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/",
		difficulty = Difficulty.MEDIUM
)
public class MinimumRoundsToCompleteAllTasks
{
	public int minimumRounds(int[] tasks)
	{
		Map<Integer, Integer> map = new HashMap<>();
		for (int task : tasks)
		{
			map.put(task, map.getOrDefault(task, 0) + 1);
		}

		PriorityQueue<Integer> pq = new PriorityQueue((a, b) -> map.getOrDefault(b, 0) - map.getOrDefault(a, 0));
		pq.addAll(map.keySet());

		int rounds = 0;
		while (!pq.isEmpty())
		{
			int key = pq.remove();
			int count = map.remove(key);
			if (count >= 5 || count == 3)
			{
				count -= 3;
			}
			else if (count != 1)
			{
				count -= 2;
			}

			if (count == 1)
			{
				return -1;
			}

			if (count > 0)
			{
				map.put(key, count);
				pq.add(key);
			}

			rounds++;
		}

		return rounds;
	}
}
