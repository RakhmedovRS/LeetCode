package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author RakhmedovRS
 * @created 10-Sep-20
 */
@LeetCode(
	id = 855,
	name = "Exam Room",
	url = "https://leetcode.com/problems/exam-room/",
	difficulty = Difficulty.MEDIUM
)
public class ExamRoom
{
	int n;

	class Interval
	{
		int start;
		int end;
		int length;

		public Interval(int start, int end)
		{
			this.start = start;
			this.end = end;
			if (start == 0 || end == n - 1)
			{
				length = end - start;
			}
			else
			{
				length = (end - start) / 2;
			}
		}
	}

	PriorityQueue<Interval> seats;

	public ExamRoom(int N)
	{
		n = N;
		seats = new PriorityQueue<>((i1, i2) ->
		{
			int distance = i2.length - i1.length;
			if (distance != 0)
			{
				return distance;
			}
			return i1.start - i2.start;
		});

		seats.add(new Interval(0, N - 1));
	}

	public int seat()
	{
		Interval interval = seats.remove();
		int seat;
		if (interval.start == 0)
		{
			seat = 0;
		}
		else if (interval.end == n - 1)
		{
			seat = n - 1;
		}
		else
		{
			seat = interval.start + interval.length;
		}

		if (seat > interval.start)
		{
			seats.add(new Interval(interval.start, seat - 1));
		}
		if (seat < interval.end)
		{
			seats.add(new Interval(seat + 1, interval.end));
		}

		return seat;
	}

	public void leave(int p)
	{
		List<Interval> intervals = new ArrayList<>(seats);
		Interval prev = null;
		Interval next = null;
		for (Interval interval : intervals)
		{
			if (interval.start == p + 1)
			{
				next = interval;
			}

			if (interval.end == p - 1)
			{
				prev = interval;
			}
		}

		seats.remove(prev);
		seats.remove(next);

		int start = prev == null ? p : prev.start;
		int end = next == null ? p : next.end;
		seats.add(new Interval(start, end));
	}
}
