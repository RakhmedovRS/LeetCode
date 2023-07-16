package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 16-Mar-20
 */
@LeetCode(
		id = 706,
		name = "Design HashMap",
		url = "https://leetcode.com/problems/design-hashmap/",
		difficulty = Difficulty.EASY
)
public class DesignHashMap
{
	class MyHashMap
	{

		int[] values;

		public MyHashMap()
		{
			values = new int[1000000];
			Arrays.fill(values, -1);
		}

		/**
		 * value will always be non-negative.
		 */
		public void put(int key, int value)
		{
			values[key] = value;
		}

		/**
		 * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
		 */
		public int get(int key)
		{
			return values[key];
		}

		/**
		 * Removes the mapping of the specified value key if this map contains a mapping for the key
		 */
		public void remove(int key)
		{
			values[key] = -1;
		}
	}

	public static void main(String[] args)
	{
		MyHashMap hashMap = new DesignHashMap().new MyHashMap();
		hashMap.put(1, 1);
		hashMap.put(2, 2);
		hashMap.get(1);            // returns 1
		hashMap.get(3);            // returns -1 (not found)
		hashMap.put(2, 1);          // update the existing value
		hashMap.get(2);            // returns 1
		hashMap.remove(2);          // remove the mapping for 2
		hashMap.get(2);            // returns -1 (not found)
	}
}
