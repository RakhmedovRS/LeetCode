package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12-May-20
 */
@LeetCode(
		id = 1385,
		name = "Find the Distance Value Between Two Arrays",
		url = "https://leetcode.com/problems/find-the-distance-value-between-two-arrays/",
		difficulty = Difficulty.EASY
)
public class FindTheDistanceValueBetweenTwoArrays
{
	public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
		int count = 0;
		if(arr1 == null || arr1.length == 0 || arr2 == null || arr2.length == 0)
		{
			return count;
		}

		for(int num1: arr1)
		{
			boolean valid = true;
			for(int num2: arr2)
			{
				if (Math.abs(num1 - num2) <= d)
				{
					valid = false;
					break;
				}
			}
			if (valid)
			{
				count++;
			}
		}
		return count;
	}
}
