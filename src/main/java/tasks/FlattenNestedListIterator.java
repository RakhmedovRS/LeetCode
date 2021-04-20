package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 27-Apr-20
 */
@LeetCode(
	id = 341,
	name = "Flatten Nested List Iterator",
	url = "https://leetcode.com/problems/flatten-nested-list-iterator/",
	difficulty = Difficulty.MEDIUM
)
public class FlattenNestedListIterator
{
	public interface NestedInteger
	{
		// @return true if this NestedInteger holds a single integer, rather than a nested list.
		public boolean isInteger();

		// @return the single integer that this NestedInteger holds, if it holds a single integer
		// Return null if this NestedInteger holds a nested list
		public Integer getInteger();

		// @return the nested list that this NestedInteger holds, if it holds a nested list
		// Return null if this NestedInteger holds a single integer
		public List<NestedInteger> getList();
	}

	public class NestedIterator implements Iterator<Integer>
	{

		LinkedList<Integer> list;

		public NestedIterator(List<NestedInteger> nestedList)
		{
			list = new LinkedList<>();
			traverse(nestedList, list);
		}

		@Override
		public Integer next()
		{
			return list.removeFirst();
		}

		@Override
		public boolean hasNext()
		{
			return !list.isEmpty();
		}

		private void traverse(List<NestedInteger> nestedList, LinkedList<Integer> list)
		{
			for (NestedInteger nestedInteger : nestedList)
			{
				if (nestedInteger.isInteger())
				{
					list.addLast(nestedInteger.getInteger());
				}
				else
				{
					traverse(nestedInteger.getList(), list);
				}
			}
		}
	}
}
