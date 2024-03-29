package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.PriorityQueue;

/**
 * @author RakhmedovRS
 * @created 11/1/2020
 */
@LeetCode(
		id = 1642,
		name = "Furthest Building You Can Reach",
		url = "https://leetcode.com/problems/furthest-building-you-can-reach/",
		difficulty = Difficulty.MEDIUM
)
public class FurthestBuildingYouCanReach {
	public int furthestBuilding(int[] heights, int bricks, int ladders) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < heights.length - 1; i++) {
			if (heights[i] < heights[i + 1]) {
				pq.add(heights[i + 1] - heights[i]);
				if (ladders > 0) {
					ladders--;
				}
				else {
					if (pq.isEmpty() || pq.peek() > bricks) {
						return i;
					}

					bricks -= pq.remove();
				}
			}
		}

		return heights.length - 1;
	}

	public static void main(String[] args) {
		System.out.println(new FurthestBuildingYouCanReach().furthestBuilding(new int[]{4, 12, 2, 7, 3, 18, 20, 3, 19}, 4, 2));//4
		System.out.println(new FurthestBuildingYouCanReach().furthestBuilding(new int[]{4, 2, 7, 6, 9, 14, 12}, 5, 1)); //4
	}
}
