package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 11-Sep-20
 */
@LeetCode(
	id = 432,
	name = "All O`one Data Structure",
	url = "https://leetcode.com/problems/all-oone-data-structure/",
	difficulty = Difficulty.HARD
)
public class AllOoneDataStructure
{
	class AllOne
	{
		class Link
		{
			Link next;
			Link prev;
			String key;
			Integer count;

			public Link(String key, Integer count)
			{
				this.key = key;
				this.count = count;
			}

			@Override
			public String toString()
			{
				StringBuilder sb = new StringBuilder();
				Link temp = this;
				while (temp != null)
				{
					sb.append(String.format("[%s & %d] -> ", temp.key, temp.count));
					temp = temp.next;
				}

				return sb.toString();
			}
		}

		Map<String, Link> keys;
		Link head;
		Link tail;
		String headKey;
		String tailKey;

		public AllOne()
		{
			keys = new HashMap<>();
			headKey = this.getClass().toString() + ".head";
			tailKey = this.getClass().toString() + ".tail";
			head = new Link(headKey, Integer.MIN_VALUE);
			tail = new Link(tailKey, Integer.MAX_VALUE);
			head.next = tail;
			tail.prev = head;

			keys.put(headKey, head);
			keys.put(tailKey, tail);
		}

		/**
		 * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
		 */
		public void inc(String key)
		{
			if (keys.containsKey(key))
			{
				Link link = keys.get(key);
				link.count++;
				if (link.count > link.next.count)
				{
					Link prev = link.prev;
					Link next = link.next;

					prev.next = next;
					next.prev = prev;

					while (link.count > next.count)
					{
						prev = next;
						next = next.next;
					}

					link.next = prev.next;
					link.prev = prev;
					next.prev = link;
					prev.next = link;
				}
			}
			else
			{
				Link link = new Link(key, 1);
				link.next = head.next;
				head.next.prev = link;
				link.prev = head;
				head.next = link;
				keys.put(key, link);
			}
		}

		/**
		 * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
		 */
		public void dec(String key)
		{
			if (keys.containsKey(key))
			{
				Link link = keys.get(key);
				link.count--;

				Link prev = link.prev;
				Link next = link.next;

				if (link.count == 0)
				{
					prev.next = next;
					next.prev = prev;

					link.prev = null;
					link.next = null;

					keys.remove(key);
				}
				else if (link.count < prev.count)
				{
					prev.next = next;
					next.prev = prev;

					while (link.count < prev.count)
					{
						next = prev;
						prev = prev.prev;
					}

					prev.next = link;
					link.prev = prev;
					link.next = next;
					next.prev = link;
				}
			}
		}

		/**
		 * Returns one of the keys with maximal value.
		 */
		public String getMaxKey()
		{
			return tail.prev.key.equals(headKey) ? "" : tail.prev.key;
		}

		/**
		 * Returns one of the keys with Minimal value.
		 */
		public String getMinKey()
		{
			return head.next.key.equals(tailKey) ? "" : head.next.key;
		}
	}
}
