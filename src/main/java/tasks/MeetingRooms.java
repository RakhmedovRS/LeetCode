package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 11/29/2020
 */
@LeetCode(
	id = 252,
	name = "Meeting Rooms",
	url = "https://leetcode.com/problems/meeting-rooms/",
	difficulty = Difficulty.EASY,
	premium = true
)
public class MeetingRooms
{
	public boolean canAttendMeetings(int[][] intervals)
	{
		Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
		for (int i = 1; i < intervals.length; i++)
		{
			if (intervals[i - 1][1] > intervals[i][0])
			{
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args)
	{
		System.out.println(new MeetingRooms().canAttendMeetings(new int[][]
			{
				{7, 10},
				{2, 4}
			}));

		System.out.println(new MeetingRooms().canAttendMeetings(new int[][]
			{
				{0, 30},
				{5, 10},
				{15, 20}
			}));
	}
}
