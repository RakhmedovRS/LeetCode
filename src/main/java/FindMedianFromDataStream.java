import common.LeetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 16-Mar-20
 */
@LeetCode(id = 295, name = "Find Median from Data Stream", url = "https://leetcode.com/problems/find-median-from-data-stream/")
public class FindMedianFromDataStream
{
	class MedianFinder
	{
		private List<Integer> inner;

		public MedianFinder()
		{
			inner = new ArrayList<>();
		}

		public void addNum(int num)
		{
			inner.add(num);
		}

		public double findMedian()
		{
			if (inner.isEmpty())
			{
				return 0D;
			}

			inner.sort(Comparator.naturalOrder());

			if (inner.size() % 2 != 0)
			{
				return inner.get(inner.size() / 2);
			}
			else
			{
				return (inner.get(inner.size() / 2 - 1) + inner.get(inner.size() / 2)) / 2D;
			}
		}
	}
}
