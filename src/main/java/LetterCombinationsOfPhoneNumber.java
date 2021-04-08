import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 07-Apr-20
 */
@LeetCode(
	id = 17,
	name = "Letter Combinations of a Phone Number",
	url = "https://leetcode.com/problems/letter-combinations-of-a-phone-number/",
	difficulty = Difficulty.MEDIUM
)
public class LetterCombinationsOfPhoneNumber
{
	public List<String> letterCombinations(String digits)
	{
		if (digits.isEmpty())
		{
			return Collections.emptyList();
		}
		char[][] chars = new char[][]{{}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
		return dfs(0, digits.toCharArray(), chars);
	}

	private List<String> dfs(int pos, char[] digits, char[][] chars)
	{
		if (pos == digits.length)
		{
			return Arrays.asList("");
		}

		List<String> next = dfs(pos + 1, digits, chars);
		List<String> result = new ArrayList<>();
		for (char ch : chars[digits[pos] - '0'])
		{
			for (String nextStr : next)
			{
				result.add(ch + nextStr);
			}
		}

		return result;
	}
}
