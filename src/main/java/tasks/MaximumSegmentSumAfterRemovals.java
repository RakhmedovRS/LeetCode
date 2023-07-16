package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author Ruslan Rakhmedov
 * @created 8/25/2022
 * @Ruslan Rakhmedov$
 * @1.0$
 */
@LeetCode(
		id = 2382,
		name = "Maximum Segment Sum After Removals",
		url = "https://leetcode.com/problems/maximum-segment-sum-after-removals/",
		difficulty = Difficulty.HARD
)
public class MaximumSegmentSumAfterRemovals
{
	class Segment
	{
		int start;
		int end;

		public Segment(int start, int end)
		{
			this.start = start;
			this.end = end;
		}
	}

	private Segment findParent(Segment segment, Map<Segment, Segment> connections)
	{
		while (connections.containsKey(segment))
		{
			segment = connections.get(segment);
		}

		return segment;
	}

	public long[] maximumSegmentSum(int[] nums, int[] removeQueries)
	{
		long[] cummulativeSum = new long[nums.length];
		cummulativeSum[0] = nums[0];
		for (int i = 1; i < nums.length; i++)
		{
			cummulativeSum[i] += nums[i] + cummulativeSum[i - 1];
		}

		TreeSet<Segment> segments = new TreeSet<>(Comparator.comparingInt(a -> (a.start + a.end)));
		segments.add(new Segment(0, nums.length - 1));

		TreeMap<Long, Integer> maxSums = new TreeMap<>();
		maxSums.put(cummulativeSum[cummulativeSum.length - 1], 1);
		maxSums.put(0L, 1);

		long[] answer = new long[nums.length];
		for (int i = 0; i < removeQueries.length; i++)
		{
			int pos = removeQueries[i];
			Segment segment = segments.floor(new Segment(pos, pos));
			if (segment == null || segment.start > pos || segment.end < pos)
			{
				segment = segments.ceiling(new Segment(pos, pos));
			}
			segments.remove(segment);

			int start = segment.start;
			int end = segment.end;

			long sum = cummulativeSum[end] - (start == 0 ? 0 : cummulativeSum[start - 1]);
			int count = maxSums.remove(sum) - 1;
			if (count > 0)
			{
				maxSums.put(sum, count);
			}

			if (start < pos && pos < end)
			{
				segments.add(new Segment(start, pos - 1));
				sum = cummulativeSum[pos - 1] - (start == 0 ? 0 : cummulativeSum[segment.start - 1]);
				maxSums.put(sum, maxSums.getOrDefault(sum, 0) + 1);

				segments.add(new Segment(pos + 1, end));
				sum = cummulativeSum[end] - cummulativeSum[pos];
				maxSums.put(sum, maxSums.getOrDefault(sum, 0) + 1);
			}
			else if (start == pos)
			{
				segments.add(new Segment(pos + 1, end));
				sum = cummulativeSum[end] - cummulativeSum[pos];
				maxSums.put(sum, maxSums.getOrDefault(sum, 0) + 1);
			}
			else
			{
				segments.add(new Segment(start, pos - 1));
				sum = cummulativeSum[pos - 1] - (start == 0 ? 0 : cummulativeSum[segment.start - 1]);
				maxSums.put(sum, maxSums.getOrDefault(sum, 0) + 1);
			}

			answer[i] = maxSums.lastKey();
		}

		return answer;
	}
}
