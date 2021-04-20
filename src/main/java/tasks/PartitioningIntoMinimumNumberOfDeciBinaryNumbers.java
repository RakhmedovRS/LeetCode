package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12/13/2020
 */
@LeetCode(
	id = 1689,
	name = "Partitioning Into Minimum Number Of Deci-Binary Numbers",
	url = "https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/",
	difficulty = Difficulty.MEDIUM
)
public class PartitioningIntoMinimumNumberOfDeciBinaryNumbers
{
	public int minPartitions(String n)
	{
		int max = 0;
		for (char ch : n.toCharArray())
		{
			max = Math.max(max, ch - '0');
		}

		return max;
	}
}
