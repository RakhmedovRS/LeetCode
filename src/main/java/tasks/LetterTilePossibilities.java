package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 18.06.2020
 */
@LeetCode(id = 1079, name = "Letter Tile Possibilities", url = "https://leetcode.com/problems/letter-tile-possibilities/")
public class LetterTilePossibilities
{
	public int numTilePossibilities(String tiles)
	{
		if (tiles.length() < 2)
		{
			return tiles.length();
		}

		int[] memo = new int[26];
		for (char ch: tiles.toCharArray())
		{
			memo[ch - 'A']++;
		}
		int[] res = new int[]{0};
		calc(memo, res);
		return res[0];
	}

	private void calc(int[] memo, int[] res)
	{
		for (int i = 0; i < 26; i++)
		{
			if (memo[i] > 0)
			{
				memo[i]--;
				res[0]++;
				calc(memo, res);
				memo[i]++;
			}
		}
	}
}
