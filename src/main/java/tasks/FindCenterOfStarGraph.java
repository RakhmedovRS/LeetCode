package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 3/14/2021
 */
@LeetCode(
	id = 1791,
	name = "Find Center of Star Graph",
	url = "https://leetcode.com/problems/find-center-of-star-graph/",
	difficulty = Difficulty.MEDIUM
)
public class FindCenterOfStarGraph
{
	public int findCenter(int[][] edges)
	{
		int[] nodes = new int[edges.length + 2];
		for (int[] edge : edges)
		{
			nodes[edge[0]]++;
			nodes[edge[1]]++;
		}

		for (int i = 1; i < nodes.length; i++)
		{
			if (nodes[i] == edges.length)
			{
				return i;
			}
		}

		return -1;
	}

	public static void main(String[] args)
	{
		FindCenterOfStarGraph clazz = new FindCenterOfStarGraph();
		System.out.println(clazz.findCenter(new int[][]
			{
				{1, 2},
				{2, 3},
				{4, 2}
			}));

		System.out.println(clazz.findCenter(new int[][]
			{
				{1, 2},
				{5, 1},
				{1, 3},
				{1, 4}
			}));
	}
}
