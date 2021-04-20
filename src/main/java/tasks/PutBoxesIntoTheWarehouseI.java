package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 1/18/2021
 */
@LeetCode(
	id = 1564,
	name = "Put Boxes Into the Warehouse I",
	url = "https://leetcode.com/problems/put-boxes-into-the-warehouse-i/",
	difficulty = Difficulty.MEDIUM,
	premium = true
)
public class PutBoxesIntoTheWarehouseI
{
	public int maxBoxesInWarehouse(int[] boxes, int[] warehouse)
	{
		int min = warehouse[0];
		int[] mins = new int[warehouse.length];
		for (int i = 0; i < mins.length; i++)
		{
			min = Math.min(min, warehouse[i]);
			mins[i] = min;
		}

		Arrays.sort(boxes);

		int answer = 0;
		int pos = 0;
		for (int i = mins.length - 1; i >= 0; i--)
		{
			if (pos < boxes.length && boxes[pos] <= mins[i])
			{
				answer++;
				pos++;
			}
		}

		return answer;
	}
}
