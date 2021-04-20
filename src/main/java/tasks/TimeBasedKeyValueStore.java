package tasks;

import common.LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author RakhmedovRS
 * @created 30-Jul-20
 */
@LeetCode(id = 981, name = "Time Based Key-Value Store", url = "https://leetcode.com/problems/time-based-key-value-store/")
public class TimeBasedKeyValueStore
{
	class TimeMap
	{

		Map<String, TreeMap<Integer, String>> map;

		public TimeMap()
		{
			map = new HashMap<>();
		}

		public void set(String key, String value, int timestamp)
		{
			map.putIfAbsent(key, new TreeMap<>());
			map.get(key).put(timestamp, value);
		}

		public String get(String key, int timestamp)
		{
			if (!map.containsKey(key))
			{
				return "";
			}

			Map.Entry<Integer, String> entry = map.get(key).floorEntry(timestamp);
			return entry == null ? "" : entry.getValue();
		}
	}
}
