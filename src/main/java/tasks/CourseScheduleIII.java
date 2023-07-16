package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author RakhmedovRS
 * @created 5/2/2021
 */
@LeetCode(
		id = 630,
		name = "Course Schedule III",
		url = "https://leetcode.com/problems/course-schedule-iii/",
		difficulty = Difficulty.HARD
)
public class CourseScheduleIII
{
	public int scheduleCourse(int[][] courses)
	{
		Arrays.sort(courses, Comparator.comparingInt(c -> c[1]));
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		int currentTime = 0;
		for (int[] course : courses)
		{
			if (currentTime + course[0] <= course[1])
			{
				pq.add(course[0]);
				currentTime += course[0];
			}
			else if (!pq.isEmpty() && pq.peek() > course[0])
			{
				currentTime += course[0] - pq.remove();
				pq.add(course[0]);
			}
		}

		return pq.size();
	}
}
