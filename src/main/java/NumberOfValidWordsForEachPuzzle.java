import common.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 22-Jul-20
 */
@LeetCode(id = 1789, name = "Number of Valid Words for Each Puzzle", url = "https://leetcode.com/problems/number-of-valid-words-for-each-puzzle/")
public class NumberOfValidWordsForEachPuzzle
{
	public List<Integer> findNumOfValidWords(String[] words, String[] puzzles)
	{
		Map<Integer, Integer> map = new HashMap<>();
		for (String word : words)
		{
			int mask = getMask(word);
			map.put(mask, map.getOrDefault(mask, 0) + 1);
		}

		List<Integer> result = new ArrayList<>();
		for (String puzzle : puzzles)
		{
			int count = 0;
			int mask = getMask(puzzle);
			int subMask = mask;
			int first = 1 << puzzle.charAt(0) - 'a';
			while (true)
			{
				if ((subMask & first) == first)
				{
					count += map.getOrDefault(subMask, 0);
				}

				if (subMask == 0)
				{
					break;
				}

				subMask = (subMask - 1) & mask;
			}

			result.add(count);
		}

		return result;
	}

	private int getMask(String word)
	{
		int mask = 0;
		for (char ch : word.toCharArray())
		{
			mask |= 1 << ch - 'a';
		}
		return mask;
	}
}
