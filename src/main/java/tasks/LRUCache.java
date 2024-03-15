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

	private static class CacheEntry {
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
		CacheEntry cacheEntryPrev = cacheEntry.prev;
		CacheEntry cacheEntryNext = cacheEntry.next;
		cacheEntryPrev.next = cacheEntryNext;
		cacheEntryNext.prev = cacheEntryPrev;

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
			CacheEntry cacheEntryPrev = cacheEntry.prev;
			CacheEntry cacheEntryNext = cacheEntry.next;
			cacheEntryPrev.next = cacheEntryNext;
			cacheEntryNext.prev = cacheEntryPrev;
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
			CacheEntry prev = evictedEntry.prev;
			CacheEntry next = evictedEntry.next;
			prev.next = next;
			next.prev = prev;

			cacheEntryMap.remove(evictedEntry.key);
		}
	}

	public static void main(String[] args) {
		LRUCache lruCache = new LRUCache(2);
		lruCache.put(2, 1);
		lruCache.put(1, 1);
		lruCache.put(2, 3);
		lruCache.put(4, 1);
		System.out.println(lruCache.get(1));
		System.out.println(lruCache.get(2));
	}
}
