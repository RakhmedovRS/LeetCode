package tasks;

import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 22-Aug-20
 */
@LeetCode(id = 1557, name = "Minimum Number of Vertices to Reach All Nodes", url = "https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/")
public class MinimumNumberOfVerticesToReachAllNodes
{
	public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges)
	{
		List<Integer> answer = new ArrayList<>();
		int[] outcome = new int[n];
		for (List<Integer> edge : edges)
		{
			outcome[edge.get(1)]++;
		}

		for (int i = 0; i < outcome.length; i++)
		{
			if (outcome[i] == 0)
			{
				answer.add(i);
			}
		}

		return answer;
	}
}
