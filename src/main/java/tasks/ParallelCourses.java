package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 3/29/2021
 */
@LeetCode(
	id = 1136,
	name = "Parallel Courses",
	url = "https://leetcode.com/problems/parallel-courses/",
	difficulty = Difficulty.MEDIUM,
	premium = true
)
public class ParallelCourses
{
	public int minimumSemesters(int n, int[][] relations)
	{
		int[] indegree = new int[n + 1];
		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (int[] relation : relations)
		{
			graph.putIfAbsent(relation[0], new ArrayList<>());
			graph.get(relation[0]).add(relation[1]);
			indegree[relation[1]]++;
		}

		int longestWay = Integer.MIN_VALUE;
		Integer[] memo = new Integer[n + 1];
		for (int i = 1; i <= n; i++)
		{
			if (indegree[i] == 0)
			{
				longestWay = Math.max(longestWay, dfs(i, new char[n + 1], memo, graph));
			}
		}

		return longestWay == Integer.MIN_VALUE ? -1 : longestWay;
	}

	private int dfs(int node, char[] visited, Integer[] memo, Map<Integer, List<Integer>> graph)
	{
		if (visited[node] == 'P')
		{
			return -1;
		}

		if (memo[node] != null)
		{
			return memo[node];
		}

		visited[node] = 'P';

		int longest = 1;
		for (int child : graph.getOrDefault(node, Collections.emptyList()))
		{
			int temp = dfs(child, visited, memo, graph);
			if (temp == -1)
			{
				return -1;
			}
			else
			{
				longest = Math.max(longest, temp + 1);
			}
		}

		visited[node] = 'V';

		memo[node] = longest;

		return longest;
	}
}
