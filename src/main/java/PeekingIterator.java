import common.LeetCode;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 26-May-20
 */
@LeetCode(id = 284, name = "Peeking Iterator", url = "https://leetcode.com/problems/peeking-iterator/")
class PeekingIterator implements Iterator<Integer>
{
	LinkedList<Integer> prev;
	public PeekingIterator(Iterator<Integer> iterator)
	{
		this.prev = new LinkedList<>();
		while (iterator.hasNext())
		{
			prev.addLast(iterator.next());
		}
	}

	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek()
	{
		return prev.getFirst();
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next()
	{
		return prev.removeFirst();
	}

	@Override
	public boolean hasNext()
	{
		return !prev.isEmpty();
	}
}
