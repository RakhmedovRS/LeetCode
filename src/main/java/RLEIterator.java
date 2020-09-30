import common.LeetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 9/30/2020
 */
@LeetCode(id = 900, name = "RLE Iterator", url = "https://leetcode.com/problems/rle-iterator/")
class RLEIterator
{

	Deque<int[]> pairs;

	public RLEIterator(int[] A)
	{
		pairs = new LinkedList<>();
		for (int i = 0; i < A.length; i += 2)
		{
			pairs.addLast(new int[]{A[i], A[i + 1]});
		}
	}

	public int next(int n)
	{
		int[] pair;
		while (n > 0 && !pairs.isEmpty())
		{
			pair = pairs.removeFirst();
			if (n == pair[0])
			{
				return pair[1];
			}
			else if (n > pair[0])
			{
				n -= pair[0];
			}
			else
			{
				pair[0] -= n;
				pairs.addFirst(pair);
				return pair[1];
			}
		}

		return -1;
	}
}
