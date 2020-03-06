import java.util.HashMap;
import java.util.Map;

/**
 * LRU Cache
 * LeetCode 146
 *
 * @author RakhmedovRS
 * @created 06-Mar-20
 */
public class LRUCache
{
	private class Link
	{
		int key;
		int value;
		Link next;
		Link previous;

		public Link(int key, int value)
		{
			this.key = key;
			this.value = value;
		}
	}

	private int capacity;
	private Link head;
	private Link tail;
	private Map<Integer, Link> cache;

	public LRUCache(int capacity)
	{
		this.capacity = capacity;
		head = new Link(0, 0);
		tail = new Link(0, 0);
		head.next = tail;
		tail.previous = head;
		cache = new HashMap<>();
	}

	public int get(int key)
	{
		Link target = cache.get(key);

		if (target != null)
		{
			target.previous.next = target.next;
			target.next.previous = target.previous;

			target.next = head.next;
			target.previous = head;
			head.next = target;
			target.next.previous = target;

			return target.value;
		}
		else
		{
			return -1;
		}
	}

	public void put(int key, int value)
	{
		Link newLink = cache.get(key);
		if (newLink == null)
		{
			newLink = new Link(key, value);
			head.next.previous = newLink;
			newLink.next = head.next;
			head.next = newLink;
			newLink.previous = head;
			if (capacity == 0)
			{
				Link removedLink = tail.previous;
				removedLink.previous.next = tail;
				tail.previous = removedLink.previous;
				cache.remove(removedLink.key);
			}
			else
			{
				capacity--;
			}
			cache.put(key, newLink);
		}
		else
		{
			newLink.value = value;

			newLink.previous.next = newLink.next;
			newLink.next.previous = newLink.previous;

			newLink.next = head.next;
			newLink.previous = head;
			head.next = newLink;
			newLink.next.previous = newLink;
		}
	}
}
