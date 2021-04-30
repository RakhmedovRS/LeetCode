package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 10/9/2020
 */
@LeetCode(
	id = 970,
	name = "Powerful Integers",
	url = "https://leetcode.com/problems/powerful-integers/",
	difficulty = Difficulty.MEDIUM
)
public class PowerfulIntegers
{
	public List<Integer> powerfulIntegers(int x, int y, int bound)
	{
		Set<Integer> answer = new HashSet<>();

		int xRes;
		int yRes;
		for (int powX = 0; bound > (long) Math.pow(x, powX); powX++)
		{
			xRes = (int) Math.pow(x, powX);
			for (int powY = 0; bound >= (long) Math.pow(y, powY) + xRes; powY++)
			{
				yRes = (int) Math.pow(y, powY);
				answer.add(xRes + yRes);
				if (y == 1)
				{
					break;
				}
			}

			if (x == 1)
			{
				break;
			}
		}

		return new ArrayList<>(answer);
	}
}
