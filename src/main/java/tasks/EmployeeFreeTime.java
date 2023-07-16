package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
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
	static class Interval
	{
		public int start;
		public int end;

		public Interval()
		{
		}

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

	public static void main(String[] args)
	{
		EmployeeFreeTime clazz = new EmployeeFreeTime();
		System.out.println(clazz.employeeFreeTime(
				Arrays.asList(
						Arrays.asList(new Interval(1, 2), new Interval(5, 6)),
						Arrays.asList(new Interval(1, 3)),
						Arrays.asList(new Interval(4, 10))
				)
		));

		System.out.println(clazz.employeeFreeTime(
				Arrays.asList(
						Arrays.asList(
								new Interval(11, 31), new Interval(43, 51),
								new Interval(53, 59), new Interval(61, 62),
								new Interval(68, 79)
						),
						Arrays.asList(
								new Interval(6, 36), new Interval(40, 55),
								new Interval(87, 88), new Interval(89, 93),
								new Interval(97, 98)
						),
						Arrays.asList(
								new Interval(6, 38), new Interval(49, 62),
								new Interval(71, 73), new Interval(85, 91),
								new Interval(98, 99)
						),
						Arrays.asList(
								new Interval(2, 4), new Interval(38, 40),
								new Interval(61, 65), new Interval(67, 80),
								new Interval(82, 89)
						),
						Arrays.asList(
								new Interval(8, 18), new Interval(25, 29),
								new Interval(54, 58), new Interval(65, 74),
								new Interval(85, 93)
						)
				)
		));

		System.out.println(clazz.employeeFreeTime(
				Arrays.asList(
						Arrays.asList(new Interval(43, 76), new Interval(86, 91)),
						Arrays.asList(new Interval(17, 20), new Interval(29, 30))
				)
		));
	}
}
