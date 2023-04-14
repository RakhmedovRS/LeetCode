package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 21-Sep-20
 */
@LeetCode(
		id = 1376,
		name = "Time Needed to Inform All Employees",
		url = "https://leetcode.com/problems/time-needed-to-inform-all-employees/",
		difficulty = Difficulty.MEDIUM
)
public class TimeNeededToInformAllEmployees
{
	public int numOfMinutes(int n, int headID, int[] manager, int[] informTime)
	{
		int minutes = 0;
		Map<Integer, List<Integer>> graph = new HashMap<>();
		Map<Integer, Integer> time = new HashMap<>();
		for (int i = 0; i < n; i++)
		{
			graph.putIfAbsent(manager[i], new ArrayList<>());
			graph.get(manager[i]).add(i);
			time.put(i, informTime[i]);
		}

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{headID, 0});
		while (!queue.isEmpty())
		{
			int[] pair = queue.remove();
			int head = pair[0];
			int timeNeed = pair[1];

			if (graph.getOrDefault(head, Collections.emptyList()).isEmpty())
			{
				minutes = Math.max(minutes, timeNeed);
			}

			for (int next : graph.getOrDefault(head, Collections.emptyList()))
			{
				queue.add(new int[]{next, timeNeed + time.get(head)});
			}
		}

		return minutes;
	}
}
