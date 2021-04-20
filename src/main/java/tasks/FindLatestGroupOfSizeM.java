package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 1/9/2021
 */
@LeetCode(
	id = 1562,
	name = "Find Latest Group of Size M",
	url = "https://leetcode.com/problems/find-latest-group-of-size-m/",
	difficulty = Difficulty.MEDIUM
)
public class FindLatestGroupOfSizeM
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

		public boolean hasLength(int length)
		{
			return length == 1 + end - start;
		}
	}

	public int findLatestStep(int[] arr, int m)
	{
		Map<Integer, Segment> segmentsMap = new HashMap<>();
		boolean[] bits = new boolean[arr.length];
		int pos;
		int segmentsOfSizeM = 0;
		int lastValidStep = -1;
		for (int i = 0; i < arr.length; i++)
		{
			pos = arr[i] - 1;
			bits[pos] = true;
			if (pos - 1 >= 0 && bits[pos - 1] && pos + 1 < arr.length && bits[pos + 1])
			{
				Segment segmentA = segmentsMap.remove(pos - 1);
				segmentsMap.remove(segmentA.start);
				if (segmentA.hasLength(m))
				{
					segmentsOfSizeM--;
				}

				Segment segmentB = segmentsMap.remove(pos + 1);
				segmentsMap.remove(segmentA.end);
				if (segmentB.hasLength(m))
				{
					segmentsOfSizeM--;
				}

				Segment unionSegment = new Segment(segmentA.start, segmentB.end);
				if (unionSegment.hasLength(m))
				{
					segmentsOfSizeM++;
				}

				segmentsMap.put(unionSegment.start, unionSegment);
				segmentsMap.put(unionSegment.end, unionSegment);
			}
			else if (pos - 1 >= 0 && bits[pos - 1])
			{
				Segment segmentA = segmentsMap.remove(pos - 1);
				segmentsMap.remove(segmentA.start);
				if (segmentA.hasLength(m))
				{
					segmentsOfSizeM--;
				}

				segmentA.end++;

				if (segmentA.hasLength(m))
				{
					segmentsOfSizeM++;
				}

				segmentsMap.put(segmentA.start, segmentA);
				segmentsMap.put(segmentA.end, segmentA);
			}
			else if (pos + 1 < arr.length && bits[pos + 1])
			{
				Segment segmentB = segmentsMap.remove(pos + 1);
				segmentsMap.remove(segmentB.end);
				if (segmentB.hasLength(m))
				{
					segmentsOfSizeM--;
				}

				segmentB.start--;

				if (segmentB.hasLength(m))
				{
					segmentsOfSizeM++;
				}

				segmentsMap.put(segmentB.start, segmentB);
				segmentsMap.put(segmentB.end, segmentB);
			}
			else
			{
				Segment segment = new Segment(pos, pos);
				if (segment.hasLength(m))
				{
					segmentsOfSizeM++;
				}

				segmentsMap.put(segment.start, segment);
			}

			if (segmentsOfSizeM > 0)
			{
				lastValidStep = i + 1;
			}
		}

		return lastValidStep;
	}

	public static void main(String[] args)
	{
		FindLatestGroupOfSizeM clazz = new FindLatestGroupOfSizeM();
		System.out.println(clazz.findLatestStep(new int[]{3, 2, 5, 6, 10, 8, 9, 4, 1, 7}, 3)); //8
		System.out.println(clazz.findLatestStep(new int[]{10, 6, 9, 4, 7, 8, 5, 2, 1, 3}, 1)); //8
		System.out.println(clazz.findLatestStep(new int[]{1}, 1)); //1
		System.out.println(clazz.findLatestStep(new int[]{3, 5, 1, 2, 4}, 1)); //4
		System.out.println(clazz.findLatestStep(new int[]{3, 1, 5, 4, 2}, 2)); //-1
	}
}
