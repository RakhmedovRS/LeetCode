package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

@LeetCode(
		id = 1580,
		name = "Put Boxes Into the Warehouse II",
		url = "https://leetcode.com/problems/put-boxes-into-the-warehouse-ii/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class PutBoxesIntoTheWarehouseII
{
	public int maxBoxesInWarehouse(int[] boxes, int[] warehouse)
	{
		Arrays.sort(boxes);
		int putBoxes = 0;
		int left = 0;
		int right = warehouse.length - 1;
		int boxPos = boxes.length - 1;
		int max;
		while (boxPos >= 0 && left <= right)
		{
			max = Math.max(warehouse[left], warehouse[right]);
			while (boxPos >= 0 && boxes[boxPos] > max)
			{
				boxPos--;
			}

			if (boxPos >= 0)
			{
				putBoxes++;
				if (warehouse[left] == max)
				{
					left++;
				}
				else
				{
					right--;
				}
				boxPos--;
			}
		}

		return putBoxes;
	}

	public static void main(String[] args)
	{
		PutBoxesIntoTheWarehouseII clazz = new PutBoxesIntoTheWarehouseII();
		System.out.println(clazz.maxBoxesInWarehouse(new int[]{3, 5, 5, 2}, new int[]{2, 1, 3, 4, 5}));
	}
}
