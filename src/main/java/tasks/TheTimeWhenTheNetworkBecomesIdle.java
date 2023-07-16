package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 10/16/2021
 */
@LeetCode(
		id = 2039,
		name = "The Time When the Network Becomes Idle",
		url = "https://leetcode.com/problems/the-time-when-the-network-becomes-idle/",
		difficulty = Difficulty.MEDIUM
)
public class TheTimeWhenTheNetworkBecomesIdle
{
	public int networkBecomesIdle(int[][] edges, int[] patience)
	{
		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (int[] edge : edges)
		{
			int nodeA = edge[0];
			int nodeB = edge[1];

			graph.putIfAbsent(nodeA, new ArrayList<>());
			graph.putIfAbsent(nodeB, new ArrayList<>());

			graph.get(nodeA).add(nodeB);
			graph.get(nodeB).add(nodeA);
		}

		int[] shortest = new int[patience.length];
		Arrays.fill(shortest, Integer.MAX_VALUE);

		int size;
		int steps = 0;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);

		while (!queue.isEmpty())
		{
			size = queue.size();
			while (size-- > 0)
			{
				int node = queue.remove();
				if (shortest[node] <= steps)
				{
					continue;
				}

				shortest[node] = steps;

				queue.addAll(graph.getOrDefault(node, Collections.emptyList()));
			}

			steps++;
		}

		int max = 0;
		for (int i = 1; i < patience.length; i++)
		{
			int distance = shortest[i] * 2;
			int messages = distance / patience[i] - (distance % patience[i] == 0 ? 1 : 0);
			max = Math.max(max, messages * patience[i] + distance);
		}

		return max + 1;
	}
}
