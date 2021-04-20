package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 05-Apr-20
 */
@LeetCode(id = 583, name = "Delete Operation for Two Strings", url = "https://leetcode.com/problems/delete-operation-for-two-strings/")
public class DeleteOperationForTwoStrings
{
	public int minDistance(String word1, String word2)
	{
		if (word1 == null && word2 == null)
		{
			return 0;
		}
		else if (word1 == null)
		{
			return word2.length();
		}
		else if (word2 == null)
		{
			return word1.length();
		}

		char[] first = word1.toCharArray();
		char[] second = word2.toCharArray();
		int[][] memo = new int[first.length + 1][second.length + 1];

		for (int column = 1; column < memo[0].length; column++)
		{
			memo[0][column] = memo[0][column - 1] + 1;
		}

		for (int row = 1; row < memo.length; row++)
		{
			memo[row][0] = memo[row - 1][0] + 1;
		}

		for (int row = 1; row < memo.length; row++)
		{
			for (int column = 1; column < memo[row].length; column++)
			{
				if (first[row - 1] == second[column - 1])
				{
					memo[row][column] = memo[row - 1][column - 1];
				}
				else
				{
					memo[row][column] = Math.min(memo[row - 1][column], memo[row][column - 1]) + 1;
				}
			}
		}

		return memo[first.length][second.length];
	}

	public static void main(String[] args)
	{
		System.out.println(new DeleteOperationForTwoStrings().minDistance("", ""));
		System.out.println(new DeleteOperationForTwoStrings().minDistance(null, "frog"));
		System.out.println(new DeleteOperationForTwoStrings().minDistance("dog", "frog"));
		System.out.println(new DeleteOperationForTwoStrings().minDistance("some", "some"));
		System.out.println(new DeleteOperationForTwoStrings().minDistance("dog", "thing"));
	}
}
