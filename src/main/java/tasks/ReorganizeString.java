package tasks;

import common.LeetCode;

import java.util.PriorityQueue;

/**
 * @author RakhmedovRS
 * @created 16-Jul-20
 */
@LeetCode(id = 767, name = "Reorganize String", url = "https://leetcode.com/problems/reorganize-string/")
public class ReorganizeString
{
	public String reorganizeString(String S)
	{
		StringBuilder sb = new StringBuilder();
		int[] memo = new int[26];
		for (char ch : S.toCharArray())
		{
			memo[ch - 'a']++;
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
			if (memo[b] == memo[a])
			{
				return a - b;
			}
			return memo[b] - memo[a];
		});
		for (int i = 0; i < memo.length; i++)
		{
			if (memo[i] > 0)
			{
				pq.add(i);
			}
		}

		while (!pq.isEmpty())
		{
			int first = pq.remove();
			char ch1 = (char) (first + 'a');
			if (sb.length() > 1)
			{
				if (sb.charAt(sb.length() - 1) == ch1)
				{
					return "";
				}
			}
			sb.append(ch1);
			memo[first]--;

			if (!pq.isEmpty())
			{
				int second = pq.remove();
				char ch2 = (char) (second + 'a');
				if (sb.length() > 1)
				{
					if (sb.charAt(sb.length() - 1) == ch2)
					{
						return "";
					}
				}
				sb.append(ch2);
				memo[second]--;
				if (memo[second] > 0)
				{
					pq.add(second);
				}
			}

			if (memo[first] > 0)
			{
				pq.add(first);
			}
		}

		return sb.toString();
	}
}
