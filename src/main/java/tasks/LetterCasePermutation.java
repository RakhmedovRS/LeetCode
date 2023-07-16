package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 30-May-20
 */
@LeetCode(
		id = 784,
		name = "Letter Case Permutation",
		url = "https://leetcode.com/problems/letter-case-permutation/",
		difficulty = Difficulty.MEDIUM
)
public class LetterCasePermutation
{
	public List<String> letterCasePermutation(String S)
	{
		StringBuilder sb = new StringBuilder();
		List<String> answer = new ArrayList<>();
		dfs(0, S.toCharArray(), sb, answer);
		return answer;
	}

	private void dfs(int pos, char[] chars, StringBuilder sb, List<String> answer)
	{
		if (pos == chars.length)
		{
			answer.add(sb.toString());
			return;
		}

		if (Character.isDigit(chars[pos]))
		{
			sb.append(chars[pos]);
			dfs(pos + 1, chars, sb, answer);
			sb.deleteCharAt(sb.length() - 1);
		}
		else
		{
			sb.append(Character.toUpperCase(chars[pos]));
			dfs(pos + 1, chars, sb, answer);
			sb.deleteCharAt(sb.length() - 1);

			sb.append(Character.toLowerCase(chars[pos]));
			dfs(pos + 1, chars, sb, answer);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	public static void main(String[] args)
	{
		System.out.println(new LetterCasePermutation().letterCasePermutation("a1b2"));
	}
}
