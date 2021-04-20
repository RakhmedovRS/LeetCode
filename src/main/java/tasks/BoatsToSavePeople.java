package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 1/13/2021
 */
@LeetCode(
	id = 881,
	name = "Boats to Save People",
	url = "https://leetcode.com/problems/boats-to-save-people/",
	difficulty = Difficulty.MEDIUM
)
public class BoatsToSavePeople
{
	public int numRescueBoats(int[] people, int limit)
	{
		Arrays.sort(people);
		int count = 0;
		int left = 0;
		int right = people.length - 1;
		while (left <= right)
		{
			count++;
			if (people[left] + people[right] <= limit)
			{
				left++;
			}
			right--;
		}

		return count;
	}
}
