package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 6/15/2022
 */
@LeetCode(
	id = 2300,
	name = "Successful Pairs of Spells and Potions",
	url = "https://leetcode.com/problems/successful-pairs-of-spells-and-potions/",
	difficulty = Difficulty.MEDIUM
)
public class SuccessfulPairsOfSpellsAndPotions
{
	public int[] successfulPairs(int[] spells, int[] potions, long success)
	{
		Arrays.sort(potions);
		int[] answer = new int[spells.length];
		for (int i = 0; i < spells.length; i++)
		{
			long val = (success % spells[i] == 0) ? success / spells[i] : success / spells[i] + 1;
			int index = binarySearch(potions, val);
			answer[i] = potions.length - index;
		}

		return answer;
	}

	private int binarySearch(int[] arr, long val)
	{
		int left = 0;
		int mid;
		int right = arr.length - 1;
		while (left <= right)
		{
			mid = (left + right) / 2;
			if (arr[mid] >= val)
			{
				right = mid - 1;
			}
			else
			{
				left = mid + 1;
			}
		}

		return left;
	}
}
