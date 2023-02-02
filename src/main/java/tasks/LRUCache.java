package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 06-Mar-20
 */
@LeetCode(
		id = 146,
		name = "LRU Cache",
		url = "https://leetcode.com/problems/lru-cache/",
		difficulty = Difficulty.MEDIUM
)
public class LRUCache
{
	private class Entry
	{
		private Entry prev;
		private Entry next;
		private int key;
		private int value;

		public Entry(int key, int value)
		{
			this.key = key;
			this.value = value;
		}
	}

	private Entry head;
	private Entry tail;
	private Map<Integer, Entry> map;
	int size;

	public LRUCache(int capacity)
	{
		head = new Entry(0, 0);
		tail = new Entry(0, 0);
		map = new HashMap<>();
		size = capacity;
		head.next = tail;
		tail.prev = head;
	}

	public int get(int key)
	{
		Entry entry = map.get(key);
		if (entry == null)
		{
			return -1;
		}

		entry.prev.next = entry.next;
		entry.next.prev = entry.prev;

		entry.next = head.next;
		entry.prev = head;
		head.next.prev = entry;
		head.next = entry;
		return entry.value;
	}

	public void put(int key, int value)
	{
		Entry entry = map.get(key);
		if (entry == null)
		{
			entry = new Entry(key, value);
			head.next.prev = entry;
			entry.next = head.next;
			head.next = entry;
			entry.prev = head;
			if (size == 0)
			{
				Entry removedLink = tail.prev;
				removedLink.prev.next = tail;
				tail.prev = removedLink.prev;
				map.remove(removedLink.key);
			}
			else
			{
				size--;
			}
			map.put(key, entry);
		}
		else
		{
			entry.value = value;

			entry.prev.next = entry.next;
			entry.next.prev = entry.prev;

			entry.next = head.next;
			entry.prev = head;
			head.next = entry;
			entry.next.prev = entry;
		}
	}

	public static void main(String[] args)
	{
		LRUCache lruCache = new LRUCache(2);
		lruCache.put(2, 1);
		lruCache.put(1, 1);
		lruCache.put(2, 3);
		lruCache.put(4, 1);
		System.out.println(lruCache.get(1));
		System.out.println(lruCache.get(2));
	}
}
