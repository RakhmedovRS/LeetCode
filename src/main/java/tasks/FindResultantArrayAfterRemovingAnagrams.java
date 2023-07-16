package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 5/15/2022
 */
@LeetCode(
		id = 2273,
		name = "Find Resultant Array After Removing Anagrams",
		url = "https://leetcode.com/problems/find-resultant-array-after-removing-anagrams/",
		difficulty = Difficulty.EASY
)
public class FindResultantArrayAfterRemovingAnagrams
{
	public List<String> removeAnagrams(String[] words)
	{
		LinkedList<String> list = new LinkedList<>();
		for (String word : words)
		{
			if (list.isEmpty())
			{
				list.addLast(word);
			}
			else
			{
				String prev = list.getLast();
				int[] a = createFreqTable(prev);
				int[] b = createFreqTable(word);

				boolean same = true;
				for (int i = 0; i < 26; i++)
				{
					if (a[i] != b[i])
					{
						same = false;
						break;
					}
				}

				if (!same)
				{
					list.addLast(word);
				}
			}
		}

		return list;
	}

	private int[] createFreqTable(String word)
	{
		int[] chars = new int[26];
		for (int i = 0; i < word.length(); i++)
		{
			chars[word.charAt(i) - 'a']++;
		}
		return chars;
	}
}
