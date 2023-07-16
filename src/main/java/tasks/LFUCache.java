package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author RakhmedovRS
 * @created 10/13/2020
 */
@LeetCode(
		id = 460,
		name = "LFU Cache",
		url = "https://leetcode.com/problems/lfu-cache/",
		difficulty = Difficulty.HARD
)
public class LFUCache
{
	class Link
	{
		Link prev;
		Link next;

		int key;
		int value;
		int rank;

		public Link(int key, int value)
		{
			this.key = key;
			this.value = value;
		}
	}

	class Level
	{
		Link head;
		Link tail;
		int level;

		public Level(int level)
		{
			this.level = level;
			head = new Link(Integer.MIN_VALUE, Integer.MIN_VALUE); // I use this value as a marker of the head
			tail = new Link(Integer.MAX_VALUE, Integer.MAX_VALUE); // I use this value as a marker of the tail

			head.next = tail;
			tail.prev = head;
		}
	}

	Map<Integer, Link> linkMap;
	Map<Integer, Level> levelMap;
	TreeMap<Integer, Level> minHeap;
	int capacity;
	int currentSize;

	public LFUCache(int capacity)
	{
		this.capacity = capacity;
		linkMap = new HashMap<>();
		levelMap = new HashMap<>();
		minHeap = new TreeMap<>();
	}

	public int get(int key)
	{
		Link link = linkMap.get(key);
		if (link == null)
		{
			return -1;
		}

		link.rank++;

		Link prev = link.prev;
		Link next = link.next;
		/**
		 * this section checks whether we need to delete entire level
		 * here is possible bug
		 */
		if (prev.value == Integer.MIN_VALUE && next.value == Integer.MAX_VALUE)
		{
			minHeap.remove(link.rank - 1);
			levelMap.remove(link.rank - 1);
		}
		prev.next = next;
		next.prev = prev;

		levelMap.putIfAbsent(link.rank, new Level(link.rank));
		Level level = levelMap.get(link.rank);

		prev = level.head;
		next = prev.next;

		prev.next = link;
		link.prev = prev;
		link.next = next;
		next.prev = link;

		minHeap.put(level.level, level);

		return link.value;
	}

	public void put(int key, int value)
	{
		if (capacity == 0)
		{
			return;
		}

		Link link = linkMap.get(key);
		if (currentSize < capacity || link != null)
		{
			if (link == null)
			{
				link = new Link(key, value);
				linkMap.put(key, link);

				levelMap.putIfAbsent(link.rank, new Level(link.rank));
				Level level = levelMap.get(link.rank);

				Link prev = level.head;
				Link next = prev.next;
				prev.next = link;
				link.prev = prev;
				link.next = next;
				next.prev = link;
				minHeap.put(level.level, level);
				currentSize++;
			}
			else
			{
				link.value = value;
				link.rank++;

				Level level = levelMap.get(link.rank - 1);
				Link prev = link.prev;
				Link next = link.next;

				prev.next = next;
				next.prev = prev;
				/**
				 * this section checks whether we need to delete entire level
				 * here is possible bug
				 */
				if (prev.value == Integer.MIN_VALUE && next.value == Integer.MAX_VALUE)
				{
					levelMap.remove(level.level);
					minHeap.remove(level.level);
				}

				levelMap.putIfAbsent(link.rank, new Level(link.rank));
				level = levelMap.get(link.rank);

				prev = level.head;
				next = prev.next;

				prev.next = link;
				link.prev = prev;
				link.next = next;
				next.prev = link;

				minHeap.put(level.level, level);
			}
		}
		else
		{
			currentSize--;
			Map.Entry<Integer, Level> entry = minHeap.pollFirstEntry();
			Level level = entry.getValue();
			Link tail = level.tail;
			Link current = tail.prev;
			Link prev = tail.prev.prev;
			prev.next = tail;
			tail.prev = prev;

			linkMap.remove(current.key);

			if (prev.value != Integer.MIN_VALUE)
			{
				minHeap.put(entry.getKey(), level);
			}
			else
			{
				levelMap.remove(entry.getKey());
			}

			put(key, value);
		}
	}

	public static void main(String[] args)
	{
		LFUCache lfuCache = new LFUCache(10);
		lfuCache.put(1, 1);
		lfuCache.put(2, 2);
		lfuCache.put(3, 3);
		lfuCache.put(4, 4);
		lfuCache.put(5, 5);
		lfuCache.put(Integer.MAX_VALUE, Integer.MAX_VALUE); // trying to imitate the tail
		lfuCache.put(7, 7);
		lfuCache.put(Integer.MIN_VALUE, Integer.MIN_VALUE); // trying to imitate the head
		lfuCache.put(9, 9);
		System.out.println("must 7 and returns: " + lfuCache.get(7)); //trying to reproduce the bug
		lfuCache.put(10, 10);
		lfuCache.put(11, 11); // in normal program it must evict (1,1) pair
		lfuCache.put(12, 12); // in normal program it must evict (2,2) pair
		lfuCache.put(13, 13); // in normal program it must evict (3,3) pair
		System.out.println("must return -1 but actually returns: " + lfuCache.get(1)); // must return -1
		System.out.println("must return -1 but actually returns: " + lfuCache.get(2)); // must return -1
		System.out.println("must return -1 but actually returns: " + lfuCache.get(3)); // must return -1
		System.out.println("must 4 and returns: " + lfuCache.get(4)); // works well
	}
}
