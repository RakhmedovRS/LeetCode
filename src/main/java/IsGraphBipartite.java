import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 2/14/2021
 */
@LeetCode(
	id = 785,
	name = "Is Graph Bipartite?",
	url = "https://leetcode.com/problems/is-graph-bipartite/",
	difficulty = Difficulty.MEDIUM
)
public class IsGraphBipartite
{
	public boolean isBipartite(int[][] graph)
	{
		Boolean[] colored = new Boolean[graph.length];
		Queue<Integer> queue = new LinkedList<>();
		int current;
		for (int i = 0; i < graph.length; i++)
		{
			if (colored[i] == null)
			{
				colored[i] = true;
				queue.add(i);

				while (!queue.isEmpty())
				{
					current = queue.remove();
					for (int neighbor : graph[current])
					{
						if (colored[neighbor] == null)
						{
							queue.add(neighbor);
							colored[neighbor] = !colored[current];
						}
						else if (colored[current] == colored[neighbor])
						{
							return false;
						}
					}
				}
			}
		}

		return true;
	}

	public static void main(String[] args)
	{
		IsGraphBipartite clazz = new IsGraphBipartite();

		System.out.println(clazz.isBipartite(new int[][]
			{
				{1},
				{0, 3},
				{3},
				{1, 2}
			}));

		System.out.println(clazz.isBipartite(new int[][]
			{
				{1, 3},
				{0, 2},
				{1, 3},
				{0, 2}
			}));
	}
}
