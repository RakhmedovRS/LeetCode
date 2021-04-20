package tasks;

import common.LeetCode;

import java.util.TreeMap;

/**
 * @author RakhmedovRS
 * @created 11-Aug-20
 */
@LeetCode(id = 729, name = "My Calendar I", url = "https://leetcode.com/problems/my-calendar-i/")
public class MyCalendarI
{
	class MyCalendar
	{

		TreeMap<Integer, Integer> treeMap;

		public MyCalendar()
		{
			treeMap = new TreeMap<>();
		}

		public boolean book(int start, int end)
		{
			Integer previous = treeMap.floorKey(start);
			Integer next = treeMap.ceilingKey(start);
			if ((previous == null || treeMap.get(previous) <= start)
				&& (next == null || end <= next))
			{
				treeMap.put(start, end);
				return true;
			}

			return false;
		}
	}
}
