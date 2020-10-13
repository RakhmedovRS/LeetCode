import common.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author RakhmedovRS
 * @created 10/13/2020
 */
@LeetCode(id = 677, name = "Map Sum Pairs", url = "https://leetcode.com/problems/map-sum-pairs/")
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

		public MapSum()
		{
			root = new Trie();
		}

		public void insert(String key, int val)
		{
			Trie current = root;
			int index;
			for (int i = 0; i < key.length(); i++)
			{
				index = key.charAt(i) - 'a';
				if (current.children[index] == null)
				{
					current.children[index] = new Trie();
				}
				current = current.children[index];
			}

			current.value = val;
		}

		public int sum(String prefix)
		{
			Trie current = root;
			int index;
			int sum = 0;
			for (int i = 0; i < prefix.length(); i++)
			{
				index = prefix.charAt(i) - 'a';
				if (current.children[index] == null)
				{
					return 0;
				}
				current = current.children[index];
			}

			if (current != null)
			{
				Queue<Trie> tries = new LinkedList<>();
				tries.add(current);
				Trie curr;
				while (!tries.isEmpty())
				{
					curr = tries.remove();
					sum += curr.value;

					for (int i = 0; i < 26; i++)
					{
						if (curr.children[i] != null)
						{
							tries.add(curr.children[i]);
						}
					}
				}
			}

			return sum;
		}
	}
}
