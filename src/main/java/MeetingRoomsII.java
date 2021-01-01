import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author RakhmedovRS
 * @created 1/1/2021
 */
@LeetCode(
	id = 253,
	name = "Meeting Rooms II",
	url = "https://leetcode.com/problems/meeting-rooms-ii/",
	difficulty = Difficulty.MEDIUM,
	premium = true
)
public class MeetingRoomsII
{
	public int minMeetingRooms(int[][] intervals)
	{
		if (intervals.length == 0)
		{
			return 0;
		}

		Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		minHeap.add(intervals[0][1]);
		for (int i = 1; i < intervals.length; i++)
		{
			if (intervals[i][0] >= minHeap.peek())
			{
				minHeap.remove();
			}

			minHeap.add(intervals[i][1]);
		}

		return minHeap.size();
	}
}
