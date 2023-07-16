package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.PriorityQueue;

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
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int box : boxes)
		{
			pq.add(box);
		}

		int boxesPushed = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < warehouse.length; i++)
		{
			min = Math.min(min, warehouse[i]);
			warehouse[i] = min;
		}

		for (int i = warehouse.length - 1; i >= 0 && !pq.isEmpty(); i--)
		{
			if (pq.peek() <= warehouse[i])
			{
				pq.remove();
				boxesPushed++;
			}
		}

		return boxesPushed;
	}
}
