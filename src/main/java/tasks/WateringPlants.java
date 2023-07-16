package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11/21/2021
 */
@LeetCode(
		id = 2079,
		name = "Watering Plants",
		url = "https://leetcode.com/problems/watering-plants/",
		difficulty = Difficulty.MEDIUM
)
public class WateringPlants
{
	public int wateringPlants(int[] plants, int capacity)
	{
		int steps = 0;
		int currentCapacity = capacity;
		for (int i = 0; i < plants.length; i++)
		{
			while (plants[i] > 0)
			{
				if (currentCapacity >= plants[i])
				{
					int temp = plants[i];
					plants[i] = Math.max(0, plants[i] - currentCapacity);
					currentCapacity -= temp;
					steps++;
				}
				else
				{
					currentCapacity = capacity;
					steps += i * 2;
				}
			}
		}

		return steps;
	}
}
