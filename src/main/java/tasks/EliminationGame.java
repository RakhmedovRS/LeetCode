package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 02-Sep-20
 */
@LeetCode(
		id = 390,
		name = "Elimination Game",
		url = "https://leetcode.com/problems/elimination-game/",
		difficulty = Difficulty.MEDIUM
)
public class EliminationGame
{
	public int lastRemaining(int n)
	{
		return leftToRight(n);
	}

	private static int leftToRight(int n)
	{
		if (n <= 2)
		{
			return n;
		}
		return 2 * rightToLeft(n / 2);
	}

	private static int rightToLeft(int n)
	{
		if (n <= 2)
		{
			return 1;
		}
		if (n % 2 == 1)
		{
			return 2 * leftToRight(n / 2);
		}
		return 2 * leftToRight(n / 2) - 1;
	}

	public static void main(String[] args)
	{
		for (int i = 1; i <= 100; i++)
		{
			System.out.println(i + "-" + new EliminationGame().lastRemaining(i));
		}
	}
}
