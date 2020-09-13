import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 13-Sep-20
 */
@LeetCode(id = 1583, name = "Count Unhappy Friends", url = "https://leetcode.com/problems/count-unhappy-friends/")
public class CountUnhappyFriends
{
	public int unhappyFriends(int n, int[][] preferences, int[][] pairs)
	{
		int unhappy = 0;
		Map<Integer, Integer> memo = new HashMap<>();
		for (int[] pair : pairs)
		{
			memo.put(pair[0], pair[1]);
			memo.put(pair[1], pair[0]);
		}

		for (int[] pair : pairs)
		{
			int x = pair[0];
			int y = pair[1];

			if (isUnhappy(preferences, memo, x, y))
			{
				unhappy++;
			}

			if (isUnhappy(preferences, memo, y, x))
			{
				unhappy++;
			}
		}

		return unhappy;
	}

	private boolean isUnhappy(int[][] preferences, Map<Integer, Integer> memo, int x, int y)
	{
		for (int i = 0; i < preferences[x].length && preferences[x][i] != y; i++)
		{
			int u = preferences[x][i];

			for (int v = 0; v < preferences[x].length && preferences[u][v] != memo.get(u); v++)
			{
				if (preferences[u][v] == x)
				{
					return true;
				}
			}
		}

		return false;
	}

	public static void main(String[] args)
	{
		//0
		System.out.println(new CountUnhappyFriends().unhappyFriends(4, new int[][]
				{
					{1, 3, 2},
					{2, 3, 0},
					{1, 0, 3},
					{1, 0, 2}
				},
			new int[][]
				{
					{2, 1},
					{3, 0}
				}));

		System.out.println(new CountUnhappyFriends().unhappyFriends(4, new int[][]
				{
					{1, 2, 3},
					{3, 2, 0},
					{3, 1, 0},
					{1, 2, 0}
				},
			new int[][]
				{
					{0, 1},
					{2, 3}
				}));

		System.out.println(new CountUnhappyFriends().unhappyFriends(4, new int[][]
				{
					{1, 3, 2},
					{2, 3, 0},
					{1, 3, 0},
					{0, 2, 1}
				},
			new int[][]
				{
					{1, 3},
					{0, 2}
				}));
	}
}
