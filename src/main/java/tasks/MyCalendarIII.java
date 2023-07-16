package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author RakhmedovRS
 * @version 1.0
 * @since 18.02.2021
 */
@LeetCode(
		id = 732,
		name = "My Calendar III",
		url = "https://leetcode.com/problems/my-calendar-iii/",
		difficulty = Difficulty.HARD
)
public class MyCalendarIII
{
	class MyCalendarThree
	{

		List<int[]> slots;
		TreeSet<Integer> sortedEvents;

		public MyCalendarThree()
		{
			slots = new ArrayList<>();
			sortedEvents = new TreeSet<>((a, b) ->
			{
				if (slots.get(a)[0] == slots.get(b)[0] && slots.get(a)[1] == slots.get(b)[1])
				{
					return a - b;
				}
				else if (slots.get(a)[0] == slots.get(b)[0])
				{
					return slots.get(a)[1] - slots.get(b)[1];
				}
				return slots.get(a)[0] - slots.get(b)[0];
			});
		}

		public int book(int start, int end)
		{
			slots.add(new int[]{start, end});
			sortedEvents.add(slots.size() - 1);
			int maxIntersection = 0;
			TreeMap<Integer, Integer> ends = new TreeMap<>();
			int balance = 0;
			int[] current;
			for (int index : sortedEvents)
			{
				current = slots.get(index);
				while (!ends.isEmpty() && ends.firstKey() <= current[0])
				{
					balance -= ends.remove(ends.firstKey());
				}

				balance++;
				ends.put(current[1], ends.getOrDefault(current[1], 0) + 1);

				maxIntersection = Math.max(maxIntersection, balance);
			}

			return maxIntersection;
		}
	}
}
