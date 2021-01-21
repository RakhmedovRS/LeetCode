import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 1/21/2021
 */
@LeetCode(
	id = 915,
	name = "Partition Array into Disjoint Intervals",
	url = "https://leetcode.com/problems/partition-array-into-disjoint-intervals/",
	difficulty = Difficulty.MEDIUM
)
public class PartitionArrayIntoDisjointIntervals
{
	public int partitionDisjoint(int[] A)
	{
		int min = Integer.MAX_VALUE;
		int[] minimums = new int[A.length];
		for (int i = A.length - 1; i >= 0; i--)
		{
			minimums[i] = min;
			min = Math.min(min, A[i]);
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < A.length; i++)
		{
			max = Math.max(max, A[i]);
			if (max <= minimums[i])
			{
				return i + 1;
			}
		}

		return -1;
	}
}
