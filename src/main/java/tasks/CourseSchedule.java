package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 29-May-20
 */
@LeetCode(
	id = 207,
	name = "Course Schedule",
	url = "https://leetcode.com/problems/course-schedule/",
	difficulty = Difficulty.MEDIUM
)
public class CourseSchedule
{
	public boolean canFinish(int numCourses, int[][] prerequisites)
	{
		int count = 0;
		int[] inDegree = new int[numCourses];
		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (int[] edge : prerequisites)
		{
			inDegree[edge[0]]++;
			List<Integer> child = graph.getOrDefault(edge[1], new ArrayList<>());
			child.add(edge[0]);
			graph.put(edge[1], child);
		}

		LinkedList<Integer> stack = new LinkedList<>();
		for (int i = 0; i < numCourses; i++)
		{
			if (inDegree[i] == 0)
			{
				stack.push(i);
			}
		}

		while (!stack.isEmpty())
		{
			int current = stack.pop();
			count++;
			for (int node: graph.getOrDefault(current, Collections.emptyList()))
			{
				inDegree[node]--;
				if (inDegree[node] == 0)
				{
					stack.push(node);
				}
			}
		}

		return count == numCourses;
	}
}
