import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 16-Mar-20
 */
@LeetCode(id = 706, name = "Design HashMap", url = "https://leetcode.com/problems/design-hashmap/")
public class DesignHashMap
{
	static class MyHashMap
	{
		private class Pair
		{
			private int key;
			private int value;

			public Pair(int key, int value)
			{
				this.key = key;
				this.value = value;
			}
		}

		private List<List<Pair>> inner;
		private int maxSize;
		private int currentSize;

		public MyHashMap()
		{
			maxSize = 13;
			currentSize = 0;
			inner = new ArrayList<>(maxSize);
			for (int i = 0; i < maxSize; i++)
			{
				inner.add(new ArrayList<>());
			}
		}

		public void put(int key, int value)
		{
			int hashCode = hashCode(key);
			List<Pair> bucket = inner.get(hashCode);

			boolean found = false;
			for (Pair pair : bucket)
			{
				if (pair.key == key)
				{
					pair.value = value;
					found = true;
					break;
				}
			}

			if (!found)
			{
				bucket.add(new Pair(key, value));
				currentSize++;
			}

			if (1D * currentSize / maxSize >= 0.5D)
			{
				rehash();
			}
		}

		public int get(int key)
		{
			List<Pair> bucket = inner.get(hashCode(key));
			for (Pair pair : bucket)
			{
				if (pair.key == key)
				{
					return pair.value;
				}
			}
			return -1;
		}

		public void remove(int key)
		{
			List<Pair> bucket = inner.get(hashCode(key));
			for (int i = 0; i < bucket.size(); i++)
			{
				if (bucket.get(i).key == key)
				{
					bucket.remove(i);
					currentSize--;
					break;
				}
			}
		}

		private int hashCode(int key)
		{
			return 17 * key % maxSize;
		}

		private void rehash()
		{
			maxSize <<= 1;
			List<List<Pair>> old = inner;
			inner = new ArrayList<>(maxSize);
			for (int i = 0; i < maxSize; i++)
			{
				inner.add(new ArrayList<>());
			}

			for (List<Pair> pairs : old)
			{
				for (Pair pair : pairs)
				{
					inner.get(hashCode(pair.key)).add(pair);
				}
			}
		}
	}

	public static void main(String[] args)
	{
		MyHashMap hashMap = new MyHashMap();
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
