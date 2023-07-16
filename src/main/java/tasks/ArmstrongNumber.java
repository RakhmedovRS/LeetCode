package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 11/29/2020
 */
@LeetCode(
		id = 1134,
		name = "Armstrong Number",
		url = "https://leetcode.com/problems/armstrong-number/",
		difficulty = Difficulty.EASY,
		premium = true
)
public class ArmstrongNumber
{
	public boolean isArmstrong(int n)
	{
		List<Integer> nums = new ArrayList<>();
		int temp = n;
		while (temp > 0)
		{
			nums.add(temp % 10);
			temp /= 10;
		}

		for (int i = 0; i < 100; i++)
		{
			long number = 0;
			for (int num : nums)
			{
				number += Math.pow(num, i);
				if (number > n)
				{
					return false;
				}
			}

			if (number > n)
			{
				return false;
			}
			else if (number == n)
			{
				return true;
			}
		}

		return false;
	}
}
