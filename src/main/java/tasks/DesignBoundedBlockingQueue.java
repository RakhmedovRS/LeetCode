package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 12/22/2020
 */
@LeetCode(
	id = 1188,
	name = "Design Bounded Blocking Queue",
	url = "https://leetcode.com/problems/design-bounded-blocking-queue/",
	difficulty = Difficulty.MEDIUM,
	premium = true
)
public class DesignBoundedBlockingQueue
{
	class BoundedBlockingQueue
	{
		int capacity;
		LinkedList<Integer> list;

		public BoundedBlockingQueue(int capacity)
		{
			this.capacity = capacity;
			list = new LinkedList<>();
		}

		public void enqueue(int element) throws InterruptedException
		{
			while (capacity == list.size())
			{
				Thread.sleep(10);
			}

			list.addFirst(element);
		}

		public int dequeue() throws InterruptedException
		{
			while (list.isEmpty())
			{
				Thread.sleep(10);
			}

			return list.removeLast();
		}

		public int size()
		{
			return list.size();
		}
	}
}
