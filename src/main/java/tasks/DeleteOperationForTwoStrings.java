package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 05-Apr-20
 */
@LeetCode(
		id = 583,
		name = "Delete Operation for Two Strings",
		url = "https://leetcode.com/problems/delete-operation-for-two-strings/",
		difficulty = Difficulty.MEDIUM
)
public class DeleteOperationForTwoStrings
{
	public int minDistance(String word1, String word2)
	{
		Integer[][] memo = new Integer[word1.length() + 1][word2.length() + 1];
		return minDistance(0, word1.toCharArray(), 0, word2.toCharArray(), memo);
	}

	private int minDistance(int w1Index, char[] w1Chars, int w2Index, char[] w2Chars, Integer[][] memo)
	{
		if (w1Index == w1Chars.length)
		{
			return w2Chars.length - w2Index;
		}
		else if (w2Index == w2Chars.length)
		{
			return w1Chars.length - w1Index;
		}

		if (memo[w1Index][w2Index] != null)
		{
			return memo[w1Index][w2Index];
		}

		if (w1Chars[w1Index] == w2Chars[w2Index])
		{
			memo[w1Index][w2Index] = Math.min(minDistance(w1Index + 1, w1Chars, w2Index + 1, w2Chars, memo),
					1 + Math.min(minDistance(w1Index + 1, w1Chars, w2Index, w2Chars, memo),
							minDistance(w1Index, w1Chars, w2Index + 1, w2Chars, memo)));
		}
		else
		{
			memo[w1Index][w2Index] = 1 + Math.min(minDistance(w1Index + 1, w1Chars, w2Index, w2Chars, memo),
					minDistance(w1Index, w1Chars, w2Index + 1, w2Chars, memo));
		}

		return memo[w1Index][w2Index];
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
