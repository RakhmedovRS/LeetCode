package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 11/30/2020
 */
@LeetCode(
		id = 346,
		name = "Moving Average from Data Stream",
		url = "https://leetcode.com/problems/moving-average-from-data-stream/",
		difficulty = Difficulty.EASY,
		premium = true
)
public class MovingAverageFromDataStream
{
	class MovingAverage
	{
		LinkedList<Integer> linkedList;
		int size;
		int sum;

		public MovingAverage(int size)
		{
			linkedList = new LinkedList<>();
			this.size = size;
			sum = 0;
		}

		public double next(int val)
		{
			sum += val;
			linkedList.addLast(val);
			if (linkedList.size() > size)
			{
				sum -= linkedList.removeFirst();
			}

			return 1D * sum / linkedList.size();
		}
	}
}
