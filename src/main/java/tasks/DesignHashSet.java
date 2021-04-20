package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 26-Jun-20
 */
@LeetCode(id = 705, name = "Design HashSet", url = "https://leetcode.com/problems/design-hashset/")
public class DesignHashSet
{

	class MyHashSet
	{
		boolean[] bucket;

		public MyHashSet()
		{
			bucket = new boolean[1000000];
		}

		public void add(int key)
		{
			bucket[key] = true;
		}

		public void remove(int key)
		{
			bucket[key] = false;
		}

		public boolean contains(int key)
		{
			return bucket[key];
		}
	}
}
