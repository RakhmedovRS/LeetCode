package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 2/13/2022
 */
@LeetCode(
	id = 2171,
	name = "Removing Minimum Number of Magic Beans",
	url = "https://leetcode.com/problems/removing-minimum-number-of-magic-beans/",
	difficulty = Difficulty.MEDIUM
)
public class RemovingMinimumNumberOfMagicBeans
{
	public long minimumRemoval(int[] beans)
	{
		Arrays.sort(beans);
		long totalSum = 0;
		for (int bean : beans)
		{
			totalSum += bean;
		}

		long min = Long.MAX_VALUE;
		long runSum = 0;
		for (int i = 0; i < beans.length; i++)
		{
			long res = runSum + ((totalSum - runSum) - ((long) beans[i] * (beans.length - i)));
			min = Math.min(min, res >= 0 ? res : min);
			runSum += beans[i];
		}

		return min == Long.MAX_VALUE ? 0 : min;
	}
}
