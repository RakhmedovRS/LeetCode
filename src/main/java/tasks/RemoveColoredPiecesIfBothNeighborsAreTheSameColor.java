package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Locale;

/**
 * @author RakhmedovRS
 * @created 10/16/2021
 */
@LeetCode(
	id = 2038,
	name = "Remove Colored Pieces if Both Neighbors are the Same Color",
	url = "https://leetcode.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/",
	difficulty = Difficulty.MEDIUM
)
public class RemoveColoredPiecesIfBothNeighborsAreTheSameColor
{
	public boolean winnerOfGame(String colors)
	{
		int aliceSteps = 0;
		int bobSteps = 0;
		for (int i = 1; i < colors.length() - 1; i++)
		{
			if (colors.charAt(i) == 'A')
			{
				if (colors.charAt(i - 1) == 'A' && colors.charAt(i + 1) == 'A')
				{
					aliceSteps++;
				}
			}
			else
			{
				if (colors.charAt(i - 1) == 'B'  && colors.charAt(i + 1) == 'B')
				{
					bobSteps++;
				}
			}
		}

		return aliceSteps > bobSteps;
	}
}
