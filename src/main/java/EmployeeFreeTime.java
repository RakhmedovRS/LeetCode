import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 2/10/2021
 */
@LeetCode(
	id = 759,
	name = "Employee Free Time",
	url = "https://leetcode.com/problems/employee-free-time/",
	difficulty = Difficulty.HARD,
	premium = true
)
public class EmployeeFreeTime
{
	class Interval
	{
		public int start;
		public int end;

		public Interval(){}

		public Interval(int _start, int _end)
		{
			start = _start;
			end = _end;
		}
	}

	class Point
	{
		int value;
		int openClose;

		public Point(int value, int openClose)
		{
			this.value = value;
			this.openClose = openClose;
		}
	}

	public List<Interval> employeeFreeTime(List<List<Interval>> schedule)
	{
		List<Interval> intervals = new ArrayList<>();
		List<Point> points = new ArrayList<>();
		for (List<Interval> intervalList : schedule)
		{
			for (Interval interval : intervalList)
			{
				points.add(new Point(interval.start, 0));
				points.add(new Point(interval.end, 1));
			}
		}

		points.sort((a, b) ->
		{
			if (a.value == b.value)
			{
				return a.openClose - b.openClose;
			}

			return a.value - b.value;
		});

		Point prev = null;
		Point current;
		int balance = 0;
		for (Point point : points)
		{
			current = point;
			if (balance == 0 && prev != null)
			{
				intervals.add(new Interval(prev.value, current.value));
			}

			balance += current.openClose == 0 ? 1 : -1;
			prev = current;
		}

		return intervals;
	}
}
