package tasks;

import common.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 08-Jul-20
 */
@LeetCode(id = 1177, name = "Can Make Palindrome from Substring", url = "https://leetcode.com/problems/can-make-palindrome-from-substring/")
public class CanMakePalindromeFromSubstring
{
	public List<Boolean> canMakePaliQueries(String s, int[][] queries)
	{
		List<Boolean> answer = new ArrayList<>();
		char[] chars = s.toCharArray();
		int[][] table = createTable(chars);
		for (int[] query : queries)
		{
			answer.add(check(table, query));
		}

		return answer;
	}

	private boolean check(int[][] table, int[] query)
	{
		int left = query[0];
		int right = query[1];
		int replaces = query[2];
		if (left == right || right - left <= replaces)
		{
			return true;
		}

		int[] memo = Arrays.copyOf(table[right], 26);
		if (left != 0)
		{
			for (int i = 0; i < 26; i++)
			{
				memo[i] -= table[left - 1][i];
			}
		}

		int sum = 0;
		boolean even = (1 + right - left) % 2 == 0;
		for (int count : memo)
		{
			sum += count % 2;
		}

		return (sum + (even ? 0 : -1)) / 2 <= replaces;
	}

	private int[][] createTable(char[] chars)
	{
		int[][] table = new int[chars.length][];
		int[] row = new int[26];
		for (int i = 0; i < chars.length; i++)
		{
			row[chars[i] - 'a']++;
			table[i] = row;
			row = Arrays.copyOf(row, row.length);
		}

		return table;
	}

	public static void main(String[] args)
	{
		System.out.println(new CanMakePalindromeFromSubstring().canMakePaliQueries("rkzavgdmdgt",
			new int[][]{
				{7, 9, 1}
			}));

		System.out.println(new CanMakePalindromeFromSubstring().canMakePaliQueries("hunu",
			new int[][]{
				{2, 3, 0},
				{2, 3, 0}
			}));

		System.out.println(new CanMakePalindromeFromSubstring().canMakePaliQueries("abcda",
			new int[][]{
				{3, 3, 0},
				{1, 2, 0},
				{0, 3, 1},
				{0, 3, 2},
				{0, 4, 1}
			}));
	}
}
