package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 11/21/2020
 */
@LeetCode(
	id = 1202,
	name = "Smallest String With Swaps",
	url = "https://leetcode.com/problems/smallest-string-with-swaps/",
	difficulty = Difficulty.MEDIUM
)
public class SmallestStringWithSwaps
{
	class DSU
	{
		int[] parent;

		public DSU(int n)
		{
			parent = new int[n];
			for (int i = 0; i < n; i++)
			{
				parent[i] = i;
			}
		}

		public int findParent(int node)
		{
			int p = node;
			while (p != parent[p])
			{
				p = parent[p];
			}

			int temp;
			while (node != p)
			{
				temp = parent[node];
				parent[node] = p;
				node = temp;
			}

			return p;
		}

		public void connect(int nodeA, int nodeB)
		{
			int parentA = findParent(nodeA);
			int parentB = findParent(nodeB);

			if (parentA == parentB)
			{
				return;
			}

			if (parentA < parentB)
			{
				parent[parentB] = parentA;
			}
			else
			{
				parent[parentA] = parentB;
			}
		}

		public void performSwaps(char[] chars)
		{
			for (int i = 0; i < parent.length; i++)
			{
				findParent(i);
			}

			List<Integer>[] connects = new ArrayList[chars.length];
			for (int i = 0; i < parent.length; i++)
			{
				if (connects[parent[i]] == null)
				{
					connects[parent[i]] = new ArrayList<>();
				}

				connects[parent[i]].add(i);
			}

			for (List<Integer> indices : connects)
			{
				if (indices != null && indices.size() > 1)
				{
					int[] table = new int[26];
					for (int index : indices)
					{
						table[chars[index] - 'a']++;
					}

					int i = 0;
					for (int j = 0; j < 26; j++)
					{
						while (table[j] > 0)
						{
							chars[indices.get(i++)] = (char) (j + 'a');
							table[j]--;
						}
					}
				}
			}
		}
	}

	public String smallestStringWithSwaps(String s, List<List<Integer>> pairs)
	{
		char[] chars = s.toCharArray();
		DSU dsu = new DSU(chars.length);
		for (List<Integer> pair : pairs)
		{
			dsu.connect(pair.get(0), pair.get(1));
		}

		dsu.performSwaps(chars);

		return String.valueOf(chars);
	}

	public static void main(String[] args)
	{
		System.out.println(new SmallestStringWithSwaps().smallestStringWithSwaps("zbxxxdgmbz", Arrays.asList(
			Arrays.asList(1, 0),
			Arrays.asList(7, 1),
			Arrays.asList(9, 1),
			Arrays.asList(3, 0),
			Arrays.asList(7, 1),
			Arrays.asList(0, 4),
			Arrays.asList(6, 5),
			Arrays.asList(2, 6),
			Arrays.asList(6, 4),
			Arrays.asList(6, 0)
		))); //bdgmxxxzbz

		System.out.println(new SmallestStringWithSwaps().smallestStringWithSwaps("dcab", Arrays.asList(
			Arrays.asList(0, 3),
			Arrays.asList(1, 2),
			Arrays.asList(0, 2)
		))); //abcd

		System.out.println(new SmallestStringWithSwaps().smallestStringWithSwaps("dcab", Arrays.asList(
			Arrays.asList(0, 3),
			Arrays.asList(1, 2)
		))); //bcad
	}
}
