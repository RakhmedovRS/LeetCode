import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 2/15/2021
 */
@LeetCode(
	id = 1238,
	name = "Circular Permutation in Binary Representation",
	url = "https://leetcode.com/problems/circular-permutation-in-binary-representation/",
	difficulty = Difficulty.MEDIUM
)
public class CircularPermutationInBinaryRepresentation
{
	public List<Integer> circularPermutation(int n, int start)
	{
		boolean[] used = new boolean[(int) Math.pow(2, n)];
		int[] store = new int[used.length];
		store[0] = start;
		used[start] = true;

		dfs(1, store, used);

		List<Integer> answer = new ArrayList<>(store.length);
		for (int i = 0; i < store.length; i++)
		{
			answer.add(store[i]);
		}

		return answer;
	}

	private boolean dfs(int pos, int[] store, boolean[] used)
	{
		if (pos == store.length)
		{
			return oneBitDifference(store[0], store[pos - 1]);
		}

		int prev = store[pos - 1];
		int candidate;
		for (int i = 0; i < store.length; i++)
		{
			candidate = prev ^ (1 << i);
			if (!used[candidate])
			{
				store[pos] = candidate;
				used[candidate] = true;

				if (dfs(pos + 1, store, used))
				{
					return true;
				}

				used[candidate] = false;
			}
		}

		return false;
	}

	private boolean oneBitDifference(int a, int b)
	{
		int diff = 0;
		while (a != 0 || b != 0)
		{
			if ((a & 1) != (b & 1))
			{
				diff++;
			}
			a >>= 1;
			b >>= 1;
		}

		return diff == 1;
	}
}
