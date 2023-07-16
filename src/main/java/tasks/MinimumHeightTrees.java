package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 11/4/2020
 */
@LeetCode(
		id = 310,
		name = "Minimum Height Trees",
		url = "https://leetcode.com/problems/minimum-height-trees/",
		difficulty = Difficulty.MEDIUM
)
public class MinimumHeightTrees
{
	public List<Integer> findMinHeightTrees(int n, int[][] edges)
	{
		List<Integer> answer = new ArrayList<>();
		if (edges.length == 0)
		{
			for (int i = 0; i < n; i++)
			{
				answer.add(i);
			}
			return answer;
		}

		Map<Integer, Set<Integer>> graph = new HashMap<>();
		for (int[] edge : edges)
		{
			graph.putIfAbsent(edge[0], new HashSet<>());
			graph.putIfAbsent(edge[1], new HashSet<>());

			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
		}

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < n; i++)
		{
			if (graph.get(i).size() == 1)
			{
				queue.add(i);
			}
		}

		int size;
		int current;
		int next;
		while (n > 2)
		{
			size = queue.size();
			n -= size;
			while (size-- > 0)
			{
				current = queue.remove();
				next = graph.get(current).iterator().next();
				graph.get(current).remove(next);
				graph.get(next).remove(current);
				if (graph.get(next).size() == 1)
				{
					queue.add(next);
				}
			}
		}

		return new ArrayList<>(queue);
	}

	public static void main(String[] args)
	{
		System.out.println(new MinimumHeightTrees().findMinHeightTrees(3, new int[][]
				{
						{0, 1},
						{0, 2},
				}));

		System.out.println(new MinimumHeightTrees().findMinHeightTrees(4, new int[][]
				{
						{1, 0},
						{1, 2},
						{1, 3}
				}));

		System.out.println(new MinimumHeightTrees().findMinHeightTrees(2, new int[][]
				{
						{0, 1},
				}));

		System.out.println(new MinimumHeightTrees().findMinHeightTrees(6, new int[][]
				{
						{3, 0},
						{3, 1},
						{3, 2},
						{3, 4},
						{5, 4},
				}));
	}
}
