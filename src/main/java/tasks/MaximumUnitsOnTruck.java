package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author RakhmedovRS
 * @created 1/3/2021
 */
@LeetCode(
	id = 1710,
	name = "Maximum Units on a Truck",
	url = "https://leetcode.com/problems/maximum-units-on-a-truck/",
	difficulty = Difficulty.EASY
)
public class MaximumUnitsOnTruck
{
	public int maximumUnits(int[][] boxTypes, int truckSize)
	{
		Arrays.sort(boxTypes, Comparator.comparing(a -> a[1]));
		int answer = 0;
		for (int i = boxTypes.length - 1; i >= 0 && truckSize > 0; i--)
		{
			if (truckSize >= boxTypes[i][0])
			{
				truckSize -= boxTypes[i][0];
				answer += boxTypes[i][0] * boxTypes[i][1];
			}
			else
			{
				answer += truckSize * boxTypes[i][1];
				truckSize = 0;
			}
		}

		return answer;
	}

	public static void main(String[] args)
	{
		MaximumUnitsOnTruck clazz = new MaximumUnitsOnTruck();
		System.out.println(clazz.maximumUnits(new int[][]
			{
				{5, 10},
				{2, 5},
				{4, 7},
				{3, 9}
			}, 10));
	}
}
