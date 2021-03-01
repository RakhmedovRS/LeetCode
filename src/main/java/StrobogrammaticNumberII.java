import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 3/1/2021
 */
@LeetCode(
	id = 247,
	name = "Strobogrammatic Number II",
	url = "https://leetcode.com/problems/strobogrammatic-number-ii/",
	difficulty = Difficulty.MEDIUM,
	premium = true
)
public class StrobogrammaticNumberII
{
	public List<String> findStrobogrammatic(int n)
	{
		char[] chars = new char[n];
		List<String> answer = new ArrayList<>();
		dfs(0, n - 1, chars, answer);
		return answer;
	}

	private void dfs(int left, int right, char[] chars, List<String> answer)
	{
		if (left > right)
		{
			answer.add(new String(chars));
			return;
		}

		if (left == right)
		{
			chars[left] = '0';
			answer.add(new String(chars));

			chars[left] = '1';
			answer.add(new String(chars));

			chars[left] = '8';
			answer.add(new String(chars));
			return;
		}

		if (left > 0)
		{
			chars[left] = '0';
			chars[right] = '0';
			dfs(left + 1, right - 1, chars, answer);
		}

		chars[left] = '1';
		chars[right] = '1';
		dfs(left + 1, right - 1, chars, answer);

		chars[left] = '6';
		chars[right] = '9';
		dfs(left + 1, right - 1, chars, answer);

		chars[left] = '8';
		chars[right] = '8';
		dfs(left + 1, right - 1, chars, answer);

		chars[left] = '9';
		chars[right] = '6';
		dfs(left + 1, right - 1, chars, answer);
	}
}
