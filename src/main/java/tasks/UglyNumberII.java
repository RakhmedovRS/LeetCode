package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.TreeSet;

/**
 * @author RakhmedovRS
 * @created 04-Jul-20
 */
@LeetCode(
	id = 264,
	name = "Ugly Number II",
	url = "https://leetcode.com/problems/ugly-number-ii/",
	difficulty = Difficulty.MEDIUM
)
public class UglyNumberII
{
	public int nthUglyNumber(int n)
	{
		TreeSet<Long> treeSet = new TreeSet<>();
		treeSet.add(1L);
		while (--n > 0)
		{
			Long first = treeSet.pollFirst();
			treeSet.add(first * 2);
			treeSet.add(first * 3);
			treeSet.add(first * 5);
		}

		return (int) (long) treeSet.first();
	}
}
