package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 04-Sep-20
 */
@LeetCode(
	id = 763,
	name = "Partition Labels",
	url = "https://leetcode.com/problems/partition-labels/",
	difficulty = Difficulty.MEDIUM
)
public class PartitionLabels
{
	public List<Integer> partitionLabels(String S)
	{
		List<Integer> answer = new ArrayList<>();
		char[] chars = S.toCharArray();
		int[] memo = new int[26];
		for (char ch : chars)
		{
			memo[ch - 'a']++;
		}

		int pos = 0;
		int start = 0;
		while (pos < chars.length)
		{
			boolean[] seen = new boolean[26];
			seen[chars[pos] - 'a'] = true;
			memo[chars[pos++] - 'a']--;
			while (contains(seen))
			{
				for (int i = 0; i < seen.length; i++)
				{
					if (seen[i])
					{
						while (memo[i] != 0 && pos < chars.length)
						{
							char temp = chars[pos++];
							memo[temp - 'a']--;
							seen[temp - 'a'] = true;
						}
						seen[i] = false;
					}
				}
			}
			answer.add(pos - start);
			start = pos;
		}

		return answer;
	}

	private boolean contains(boolean[] seen)
	{
		for (boolean bool : seen)
		{
			if (bool)
			{
				return true;
			}
		}
		return false;
	}
}
