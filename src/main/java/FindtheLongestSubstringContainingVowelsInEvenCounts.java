import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 11/27/2020
 */
@LeetCode(
	id = 1371,
	name = "Find the Longest Substring Containing Vowels in Even Counts",
	url = "https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/",
	difficulty = Difficulty.MEDIUM
)
public class FindtheLongestSubstringContainingVowelsInEvenCounts
{
	public int findTheLongestSubstring(String s)
	{
		Map<Character, Integer> shifts = new HashMap<>();
		shifts.put('a', 4);
		shifts.put('e', 3);
		shifts.put('i', 2);
		shifts.put('o', 1);
		shifts.put('u', 0);

		int longest = 0;
		Map<Integer, Integer> memo = new HashMap<>();
		memo.put(0, -1);
		int current = 0;
		for (int i = 0; i < s.length(); i++)
		{
			char ch = s.charAt(i);
			if (shifts.containsKey(ch))
			{
				current ^= (1 << shifts.get(ch));
			}

			if (memo.containsKey(current))
			{
				longest = Math.max(longest, i - memo.get(current));
			}
			else
			{
				memo.put(current, i);
			}
		}

		return longest;
	}
}
