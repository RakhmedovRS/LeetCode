package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author RakhmedovRS
 * @created 30-Jan-21
 */
@LeetCode(
		id = 362,
		name = "Design Hit Counter",
		url = "https://leetcode.com/problems/design-hit-counter/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class DesignHitCounter
{
	class HitCounter
	{

		/**
		 * Initialize your data structure here.
		 */
		TreeMap<Integer, Integer> map;

		public HitCounter()
		{
			map = new TreeMap<>();
		}

		/**
		 * Record a hit.
		 *
		 * @param timestamp - The current timestamp (in seconds granularity).
		 */
		public void hit(int timestamp)
		{
			map.put(timestamp, map.getOrDefault(timestamp, 0) + 1);
		}

		/**
		 * Return the number of hits in the past 5 minutes.
		 *
		 * @param timestamp - The current timestamp (in seconds granularity).
		 */
		public int getHits(int timestamp)
		{
			int hits = 0;
			Map<Integer, Integer> sub = map.subMap(Math.max(0, timestamp - 300), false, timestamp, true);
			for (int count : sub.values())
			{
				hits += count;
			}

			return hits;
		}
	}
}
