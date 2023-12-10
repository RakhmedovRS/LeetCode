package tasks;

import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 18-Jul-20
 */
@LeetCode(id = 210, name = "Course Schedule II", url = "https://leetcode.com/problems/course-schedule-ii/")
public class CourseScheduleII {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		Map<Integer, List<Integer>> graph = new HashMap<>();
		int[] income = new int[numCourses];
		for (int[] pre : prerequisites) {
			List<Integer> list = graph.getOrDefault(pre[1], new ArrayList<>());
			list.add(pre[0]);
			income[pre[0]]++;
			graph.put(pre[1], list);
		}

		Queue<Integer> queue = new LinkedList<>();
		Set<Integer> visited = new HashSet<>();
		for (int i = 0; i < income.length; i++) {
			if (income[i] == 0) {
				queue.add(i);
			}
		}

		int i = 0;
		int[] answer = new int[numCourses];
		while (!queue.isEmpty()) {
			int course = queue.remove();
			if (!visited.add(course)) {
				continue;
			}

			answer[i++] = course;

			List<Integer> nexts = graph.remove(course);
			nexts = nexts == null ? Collections.emptyList() : nexts;
			for (int next : nexts) {
				income[next]--;
				if (income[next] == 0) {
					queue.add(next);
				}
			}
		}

		if (i != numCourses) {
			return new int[0];
		}
		return answer;
	}
}
