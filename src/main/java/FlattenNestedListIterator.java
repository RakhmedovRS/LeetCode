import common.LeetCode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 27-Apr-20
 */
@LeetCode(id = 341, name = "Flatten Nested List Iterator", url = "https://leetcode.com/problems/flatten-nested-list-iterator/")
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
		private List<Integer> integers;
		int currentPos;

		public NestedIterator(List<NestedInteger> nestedList)
		{
			integers = new ArrayList<>();
			currentPos = 0;
			fillList(nestedList, integers);
		}

		@Override
		public Integer next()
		{
			return integers.get(currentPos++);
		}

		@Override
		public boolean hasNext()
		{
			return currentPos < integers.size();
		}

		private void fillList(List<NestedInteger> nestedList, List<Integer> integers)
		{
			for (NestedInteger nestedInteger : nestedList)
			{
				if (nestedInteger.isInteger())
				{
					integers.add(nestedInteger.getInteger());
				}
				else
				{
					fillList(nestedInteger.getList(), integers);
				}
			}
		}
	}
}
