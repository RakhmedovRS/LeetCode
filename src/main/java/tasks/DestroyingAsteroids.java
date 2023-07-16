package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 1/2/2022
 */
@LeetCode(
		id = 2126,
		name = "Destroying Asteroids",
		url = "https://leetcode.com/problems/destroying-asteroids/",
		difficulty = Difficulty.MEDIUM
)
public class DestroyingAsteroids
{
	public boolean asteroidsDestroyed(int mass, int[] asteroids)
	{
		Arrays.sort(asteroids);
		long current = mass;
		for (int asteroid : asteroids)
		{
			if (current >= asteroid)
			{
				current += asteroid;
			}
			else
			{
				return false;
			}
		}

		return true;
	}
}
