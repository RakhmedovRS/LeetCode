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
class LRUCache {
	private class CacheEntry {
		private final int key;
		private final int val;
		private CacheEntry prev;
		private CacheEntry next;

		public CacheEntry() {
			key = -1;
			val = -1;
		}

		public CacheEntry(int key, int val) {
			this.key = key;
			this.val = val;
		}
	}

	private final int capacity;
	private final Map<Integer, CacheEntry> cacheEntryMap;
	private final CacheEntry head;
	private final CacheEntry tail;

	public LRUCache(int capacity) {
		cacheEntryMap = new HashMap<>();
		this.capacity = capacity;
		head = new CacheEntry();
		tail = new CacheEntry();
		head.next = tail;
		tail.prev = head;
	}

	public int get(int key) {
		CacheEntry cacheEntry = cacheEntryMap.get(key);
		if (cacheEntry == null) {
			return -1;
		}
		//remove item from the current position
		removeItemFromList(cacheEntry);

		//place it next to head
		CacheEntry headNext = head.next;
		head.next = cacheEntry;
		cacheEntry.prev = head;
		cacheEntry.next = headNext;
		headNext.prev = cacheEntry;

		return cacheEntry.val;
	}

	public void put(int key, int value) {
		CacheEntry cacheEntry = cacheEntryMap.get(key);
		if (cacheEntry != null) {
			//remove item from the current position
			removeItemFromList(cacheEntry);
		}

		cacheEntry = new CacheEntry(key, value);

		//place it next to head
		CacheEntry headNext = head.next;
		head.next = cacheEntry;
		cacheEntry.prev = head;
		cacheEntry.next = headNext;
		headNext.prev = cacheEntry;

		cacheEntryMap.put(key, cacheEntry);

		evictKeyIfNeeded();
	}

	private void evictKeyIfNeeded() {
		if (cacheEntryMap.size() > capacity) {
			//remove item from the tail
			CacheEntry evictedEntry = tail.prev;
			removeItemFromList(evictedEntry);
			cacheEntryMap.remove(evictedEntry.key);
		}
	}

	private void removeItemFromList(CacheEntry entry) {
		CacheEntry prev = entry.prev;
		CacheEntry next = entry.next;
		prev.next = next;
		next.prev = prev;
	}

	public static void main(String[] args) {
		LRUCache lruCache = new LRUCache(2);
		lruCache.put(1, 1);
		lruCache.put(2, 2);
		System.out.println(lruCache.get(1));
		lruCache.put(3, 3);
		System.out.println(lruCache.get(2));
		lruCache.put(4, 4);
		System.out.println(lruCache.get(1));
		System.out.println(lruCache.get(3));
		System.out.println(lruCache.get(4));

		System.out.println("---------------------");

		LRUCache lruCache2 = new LRUCache(2);
		lruCache2.put(2, 1);
		lruCache2.put(1, 1);
		lruCache2.put(2, 3);
		lruCache2.put(4, 1);
		System.out.println(lruCache2.get(1));
		System.out.println(lruCache2.get(2));
	}
}
