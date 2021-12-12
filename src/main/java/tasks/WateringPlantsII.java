package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12/12/2021
 */
@LeetCode(
	id = 2105,
	name = "Watering Plants II",
	url = "https://leetcode.com/problems/watering-plants-ii/",
	difficulty = Difficulty.MEDIUM
)
public class WateringPlantsII
{
	public int minimumRefill(int[] plants, int capacityA, int capacityB)
	{
		int alicePos = 0;
		int bobPos = plants.length - 1;

		int refills = 0;
		int aliceCapacity = capacityA;
		int bobCapacity = capacityB;

		boolean alice = true;
		boolean bob = true;
		while (alicePos <= bobPos)
		{
			if (alicePos == bobPos)
			{
				if (aliceCapacity >= bobCapacity)
				{
					bob = false;
				}
				else
				{
					alice = false;
				}
			}

			while (alice && plants[alicePos] > 0)
			{
				if (aliceCapacity >= plants[alicePos])
				{
					aliceCapacity -= plants[alicePos];
				}
				else
				{
					refills++;
					aliceCapacity = capacityA - plants[alicePos];
				}
				plants[alicePos] = 0;
			}

			while (bob && plants[bobPos] > 0)
			{
				if (bobCapacity >= plants[bobPos])
				{
					bobCapacity -= plants[bobPos];
				}
				else
				{
					refills++;
					bobCapacity = capacityB - plants[bobPos];
				}
				plants[bobPos] = 0;
			}

			alicePos++;
			bobPos--;
		}

		return refills;
	}
}
