package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 02-Jun-20
 */
@LeetCode(id = 1450, name = "Number of Students Doing Homework at a Given Time", url = "https://leetcode.com/problems/number-of-students-doing-homework-at-a-given-time/")
public class NumberOfStudentsDoingHomeworkAtGivenTime
{
	public int busyStudent(int[] startTime, int[] endTime, int queryTime)
	{
		int busy = 0;
		for (int i = 0; i < startTime.length; i++)
		{
			if (startTime[i] <= queryTime && endTime[i] >= queryTime)
			{
				busy++;
			}
		}
		return busy;
	}
}
