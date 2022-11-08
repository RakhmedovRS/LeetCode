package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 10/1/2020
 */
@LeetCode(
		id = 455,
		name = "Assign Cookies",
		url = "https://leetcode.com/problems/assign-cookies/",
		difficulty = Difficulty.EASY
)
public class AssignCookies
{
	public int findContentChildren(int[] greed, int[] size)
	{
		Arrays.sort(greed);
		Arrays.sort(size);
		int iGreed = 0;
		int iSize = 0;
		int happyChild = 0;
		while (iGreed < greed.length && iSize < size.length)
		{
			if (greed[iGreed] > size[iSize])
			{
				iSize++;
			}
			else
			{
				iGreed++;
				iSize++;
				happyChild++;
			}
		}

		return happyChild;
	}
}
