import common.LeetCode;

import java.util.PriorityQueue;

/**
 * @author RakhmedovRS
 * @created 11/1/2020
 */
@LeetCode(id = 1642, name = "Furthest Building You Can Reach", url = "https://leetcode.com/problems/furthest-building-you-can-reach/")
public class FurthestBuildingYouCanReach
{
	public int furthestBuilding(int[] heights, int bricks, int ladders)
	{
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int diff;
		for (int i = 0; i < heights.length - 1; i++)
		{
			diff = heights[i + 1] - heights[i];
			if (diff > 0)
			{
				pq.add(diff);
			}

			if (pq.size() > ladders)
			{
				bricks -= pq.remove();
			}

			if (bricks < 0)
			{
				return i;
			}
		}

		return heights.length - 1;
	}

	public static void main(String[] args)
	{
		System.out.println(new FurthestBuildingYouCanReach().furthestBuilding(new int[]{4, 12, 2, 7, 3, 18, 20, 3, 19}, 4, 2));//7
		System.out.println(new FurthestBuildingYouCanReach().furthestBuilding(new int[]{4, 2, 7, 6, 9, 14, 12}, 5, 1)); //4
	}
}
