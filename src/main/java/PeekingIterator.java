import common.Difficulty;
import common.LeetCode;

import java.util.Iterator;

/**
 * @author RakhmedovRS
 * @created 26-May-20
 */
@LeetCode(
	id = 284,
	name = "Peeking Iterator",
	url = "https://leetcode.com/problems/peeking-iterator/",
	difficulty = Difficulty.MEDIUM
)
class PeekingIterator implements Iterator<Integer>
{
	Integer current;
	Iterator<Integer> iterator;

	public PeekingIterator(Iterator<Integer> iterator)
	{
		this.iterator = iterator;
	}

	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek()
	{
		if (current == null)
		{
			current = iterator.next();
		}
		return current;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next()
	{
		if (current == null)
		{
			return iterator.next();
		}
		else
		{
			Integer ret = current;
			current = null;
			return ret;
		}
	}

	@Override
	public boolean hasNext()
	{
		return current != null || iterator.hasNext();
	}
}
