import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 10/24/2020
 */
@LeetCode(id = 948, name = "Bag of Tokens", url = "https://leetcode.com/problems/bag-of-tokens/")
public class BagOfTokens
{
	public int bagOfTokensScore(int[] tokens, int power)
	{
		int maxScore = 0;
		int score = 0;
		Arrays.sort(tokens);
		int left = 0;
		int right = tokens.length - 1;
		while (left <= right)
		{
			if (power >= tokens[left])
			{
				power -= tokens[left++];
				score++;
			}
			else if (score > 0)
			{
				power += tokens[right--];
				score--;
			}
			else
			{
				break;
			}

			maxScore = Math.max(maxScore, score);
		}

		return maxScore;
	}
}
