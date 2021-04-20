package tasks;

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

	public int depthSum(List<NestedInteger> nestedList)
	{
		return depthSum(nestedList, 1);
	}

	private int depthSum(List<NestedInteger> nestedList, int level)
	{
		int sum = 0;
		for (NestedInteger nestedInteger : nestedList)
		{
			if (nestedInteger.isInteger())
			{
				sum += nestedInteger.getInteger() * level;
			}
			else
			{
				sum += depthSum(nestedInteger.getList(), level + 1);
			}
		}

		return sum;
	}
}
