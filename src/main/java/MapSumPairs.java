import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author RakhmedovRS
 * @created 10/13/2020
 */
@LeetCode(
		id = 677,
		name = "Map Sum Pairs",
		url = "https://leetcode.com/problems/map-sum-pairs/",
		difficulty = Difficulty.MEDIUM
)
public class MapSumPairs
{
	class Trie
	{
		Trie[] children = new Trie[26];
		int value;
	}

	class MapSum
	{

		Trie root;

		/**
		 * Initialize your data structure here.
		 */
		public MapSum()
		{
			root = new Trie();
		}

		public void insert(String key, int val)
		{
			Trie current = root;
			for (char ch : key.toCharArray())
			{
				if (current.children[ch - 'a'] == null)
				{
					current.children[ch - 'a'] = new Trie();
				}

				current = current.children[ch - 'a'];
			}

			current.value = val;
		}

		public int sum(String prefix)
		{
			int sum = 0;
			Trie current = root;
			for (char ch : prefix.toCharArray())
			{
				if (current.children[ch - 'a'] == null)
				{
					return sum;
				}

				current = current.children[ch - 'a'];
			}

			Queue<Trie> queue = new LinkedList<>();
			queue.add(current);
			while (!queue.isEmpty())
			{
				current = queue.remove();
				sum += current.value;
				for (Trie child : current.children)
				{
					if (child != null)
					{
						queue.add(child);
					}
				}
			}

			return sum;
		}
	}
}
