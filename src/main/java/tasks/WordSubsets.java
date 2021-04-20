package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 10-May-20
 */
@LeetCode(
	id = 916,
	name = "Word tasks.Subsets",
	url = "https://leetcode.com/problems/word-subsets/",
	difficulty = Difficulty.MEDIUM
)
public class WordSubsets
{
	public List<String> wordSubsets(String[] A, String[] B)
	{
		List<String> answer = new ArrayList<>();
		int[] table;
		int[] tableB = new int[26];
		for (int i = 0; i < B.length; i++)
		{
			table = buildTable(B[i]);
			for (int j = 0; j < 26; j++)
			{
				tableB[j] = Math.max(tableB[j], table[j]);
			}
		}

		outer:
		for (String word : A)
		{
			table = buildTable(word);
			int i = 0;
			for (; i < 26; i++)
			{
				if (tableB[i] > table[i])
				{
					continue outer;
				}
			}

			answer.add(word);
		}

		return answer;
	}

	private int[] buildTable(String word)
	{
		int[] table = new int[26];
		for (char ch : word.toCharArray())
		{
			table[ch - 'a']++;
		}

		return table;
	}
}
