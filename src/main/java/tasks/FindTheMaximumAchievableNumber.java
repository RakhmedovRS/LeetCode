package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 7/9/2023
 */
@LeetCode(
		id = 2769,
		name = "Find the Maximum Achievable Number",
		url = "https://leetcode.com/problems/find-the-maximum-achievable-number/",
		difficulty = Difficulty.EASY
)
public class FindTheMaximumAchievableNumber
{
	public int theMaximumAchievableX(int num, int t)
	{
		return num + t * 2;
	}
}
