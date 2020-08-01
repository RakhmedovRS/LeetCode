import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 01-Aug-20
 */
@LeetCode(id = 514, name = "Freedom Trail", url = "https://leetcode.com/problems/freedom-trail/")
public class FreedomTrail
{
	public int findRotateSteps(String ring, String key)
	{
		int[][] memo = new int[ring.length()][key.length()];
		for (int[] row : memo)
		{
			Arrays.fill(row, -1);
		}
		return findRotateSteps(ring, 0, key, 0, memo);
	}

	private int findRotateSteps(String ring, int ringPos, String key, int keyPos, int[][] memo)
	{
		if (keyPos == key.length())
		{
			return 0;
		}

		if (memo[ringPos][keyPos] != -1)
		{
			return memo[ringPos][keyPos];
		}

		int left = 1;
		int right = 1;
		int i = ringPos;
		while (ring.charAt(i) != key.charAt(keyPos))
		{
			left++;
			i--;
			if (i < 0)
			{
				i = ring.length() - 1;
			}
		}
		left += findRotateSteps(ring, i, key, keyPos + 1, memo);

		i = ringPos;
		while (ring.charAt(i) != key.charAt(keyPos))
		{
			right++;
			i++;
			if (i == ring.length())
			{
				i = 0;
			}
		}
		right += findRotateSteps(ring, i, key, keyPos + 1, memo);

		memo[ringPos][keyPos] = Math.min(left, right);

		return memo[ringPos][keyPos];
	}

	public static void main(String[] args)
	{
		System.out.println(new FreedomTrail().findRotateSteps("godding", "gd"));
	}
}
