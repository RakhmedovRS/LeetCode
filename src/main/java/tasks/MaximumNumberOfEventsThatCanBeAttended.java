package tasks;

import common.LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author RakhmedovRS
 * @created 27-Jul-20
 */
@LeetCode(id = 1353, name = "Maximum Number of Events That Can Be Attended", url = "https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/")
public class MaximumNumberOfEventsThatCanBeAttended
{
	public int maxEvents(int[][] events)
	{
		if (events == null || events.length == 0)
		{
			return 0;
		}

		Arrays.sort(events, Comparator.comparingInt(arr -> arr[0]));
		int eventIndex = 0;
		int size = events.length;
		int currentDay = 1;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int count = 0;
		while (!pq.isEmpty() || eventIndex < size)
		{
			while (!pq.isEmpty() && pq.peek() < currentDay)
			{
				pq.remove();
			}

			while (eventIndex < size && events[eventIndex][0] == currentDay)
			{
				pq.add(events[eventIndex++][1]);
			}

			if (!pq.isEmpty())
			{
				pq.remove();
				count++;
			}
			currentDay++;
		}

		return count;
	}
}
