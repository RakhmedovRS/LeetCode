import common.Difficulty;
import common.LeetCode;

import java.util.List;

/**
 * @author RakhmedovRS
 * @created 12/23/2020
 */
@LeetCode(
	id = 364,
	name = "Nested List Weight Sum II",
	url = "https://leetcode.com/problems/nested-list-weight-sum-ii/",
	difficulty = Difficulty.MEDIUM,
	premium = true
)
public class NestedListWeightSumII
{
	public interface NestedInteger
	{
		// @return true if this NestedInteger holds a single integer, rather than a nested list.
		boolean isInteger();

		// @return the single integer that this NestedInteger holds, if it holds a single integer
		// Return null if this NestedInteger holds a nested list
		Integer getInteger();

		// Set this NestedInteger to hold a single integer.
		void setInteger(int value);

		// Set this NestedInteger to hold a nested list and adds a nested integer to it.
		void add(NestedInteger ni);

		// @return the nested list that this NestedInteger holds, if it holds a nested list
		// Return null if this NestedInteger holds a single integer
		List<NestedInteger> getList();
	}

	public int depthSumInverse(List<NestedInteger> nestedList)
	{
		Integer[] levels = new Integer[5_000];
		depthSumInverse(nestedList, 1, levels);

		int level = 1;
		int sum = 0;
		for (int i = levels.length - 1; i >= 0; i--)
		{
			if (levels[i] != null)
			{
				sum += level * levels[i];
				level++;
			}
		}

		return sum;
	}

	private void depthSumInverse(List<NestedInteger> nestedList, int level, Integer[] levels)
	{
		int sum = 0;
		for (NestedInteger nestedInteger : nestedList)
		{
			if (nestedInteger.isInteger())
			{
				sum += nestedInteger.getInteger();
			}
			else
			{
				depthSumInverse(nestedInteger.getList(), level + 1, levels);
			}
		}

		if (levels[level] == null)
		{
			levels[level] = 0;
		}

		levels[level] += sum;
	}
}
