import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 12/25/2020
 */
@LeetCode(
	id = 893,
	name = "Groups of Special-Equivalent Strings",
	url = "https://leetcode.com/problems/groups-of-special-equivalent-strings/",
	difficulty = Difficulty.EASY
)
public class GroupsOfSpecialEquivalentStrings
{
	public int numSpecialEquivGroups(String[] A)
	{
		Map<String, Integer> map = new HashMap<>();
		String sortedWord;
		for (String word : A)
		{
			sortedWord = sortWord(word);
			map.put(sortedWord, map.getOrDefault(sortedWord, 0) + 1);
		}

		return map.size();
	}

	private String sortWord(String word)
	{
		int[][] table = new int[2][26];
		for (int i = 0; i < word.length(); i++)
		{
			table[i % 2][word.charAt(i) - 'a']++;
		}

		StringBuilder sb = new StringBuilder();
		int[] pos = new int[]{0, 0};
		int even = 0;
		for (int i = 0; i < word.length(); i++)
		{
			while (table[even % 2][pos[even % 2]] == 0)
			{
				pos[even % 2]++;
			}

			sb.append((char) (pos[even % 2] + 'a'));
			table[even % 2][pos[even % 2]]--;
			even++;
		}

		return sb.toString();
	}

	public static void main(String[] args)
	{
		GroupsOfSpecialEquivalentStrings clazz = new GroupsOfSpecialEquivalentStrings();
		System.out.println(clazz.numSpecialEquivGroups(new String[]{"abc", "acb", "bac", "bca", "cab", "cba"}));
		System.out.println(clazz.numSpecialEquivGroups(new String[]{"abcd", "cdab", "cbad", "xyzz", "zzxy", "zzyx"}));
	}
}
