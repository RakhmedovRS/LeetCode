package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 5/14/2022
 */
@LeetCode(
	id = 2271,
	name = "Maximum White Tiles Covered by a Carpet",
	url = "https://leetcode.com/problems/maximum-white-tiles-covered-by-a-carpet/",
	difficulty = Difficulty.MEDIUM
)
public class MaximumWhiteTilesCoveredByCarpet
{
	public int maximumWhiteTiles(int[][] tiles, int carpetLen)
	{
		int max = 0;
		Arrays.sort(tiles, Comparator.comparing(a -> a[0]));
		LinkedList<int[]> stack = new LinkedList<>();
		for (int[] tile : tiles)
		{
			if (stack.isEmpty())
			{
				stack.addLast(tile);
			}
			else
			{
				if (stack.getLast()[1] + 1 == tile[0])
				{
					int start = stack.removeLast()[0];
					tile[0] = start;
				}
				stack.addLast(tile);
			}
		}

		LinkedList<int[]> list = new LinkedList<>();
		int seenCarpet = 0;
		int seenGap = 0;
		for (int[] tile : stack)
		{
			seenCarpet += 1 + tile[1] - tile[0];
			if (!list.isEmpty())
			{
				seenGap += tile[0] - 1 - list.getLast()[1];
			}

			list.addLast(tile);
			max = Math.max(max, Math.min(seenCarpet, carpetLen - seenGap));
			while (seenCarpet + seenGap > carpetLen)
			{
				int[] first = list.removeFirst();
				seenCarpet -= 1 + first[1] - first[0];
				if (!list.isEmpty())
				{
					seenGap -= list.getFirst()[0] - 1 - first[1];
				}

				max = Math.max(max, Math.min(seenCarpet, carpetLen - seenGap));
			}

			max = Math.max(max, Math.min(seenCarpet, carpetLen - seenGap));
		}

		return max;
	}
}
