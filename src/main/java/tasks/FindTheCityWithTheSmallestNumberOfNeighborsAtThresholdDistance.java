package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 10/24/2020
 */
@LeetCode(
		id = 1334,
		name = "Find the City With the Smallest Number of Neighbors at a Threshold Distance",
		url = "https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/",
		difficulty = Difficulty.MEDIUM
)
public class FindTheCityWithTheSmallestNumberOfNeighborsAtThresholdDistance
{
	public int findTheCity(int n, int[][] edges, int distanceThreshold)
	{
		int[][] distances = new int[n][n];
		List<int[]>[] neighbors = new ArrayList[n];
		for (int i = 0; i < n; i++)
		{
			Arrays.fill(distances[i], 1_000_000_007);
			distances[i][i] = 0;
			neighbors[i] = new ArrayList<>();
		}

		int edgeA;
		int edgeB;
		int distance;
		for (int[] edge : edges)
		{
			edgeA = edge[0];
			edgeB = edge[1];
			distance = edge[2];
			neighbors[edgeA].add(new int[]{edgeB, distance});
			neighbors[edgeB].add(new int[]{edgeA, distance});
		}

		PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparing(arr -> arr[1]));
		int a;
		int b;
		for (int vertex = 0; vertex < n; vertex++)
		{
			minHeap.clear();
			minHeap.add(new int[]{vertex, 0});
			while (!minHeap.isEmpty())
			{
				a = minHeap.peek()[0];
				distance = minHeap.remove()[1];

				if (distance > distances[vertex][a])
				{
					continue;
				}

				for (int[] neighbor : neighbors[a])
				{
					b = neighbor[0];
					if (distances[vertex][b] > distance + neighbor[1])
					{
						distances[vertex][b] = distance + neighbor[1];
						minHeap.add(new int[]{b, distances[vertex][b]});
					}
				}
			}
		}

		int minCount = Integer.MAX_VALUE;
		int city = 0;
		int currentCount;
		for (int i = 0; i < n; i++)
		{
			currentCount = 0;
			for (int j = 0; j < n; j++)
			{
				if (i != j)
				{
					if (distances[i][j] <= distanceThreshold)
					{
						currentCount++;
					}
				}
			}

			if (currentCount <= minCount)
			{
				minCount = currentCount;
				city = i;
			}
		}

		return city;
	}

	public static void main(String[] args)
	{
		System.out.println(new FindTheCityWithTheSmallestNumberOfNeighborsAtThresholdDistance().findTheCity(8, new int[][]
			{
				{3, 5, 9558},
				{1, 2, 1079},
				{1, 3, 8040},
				{0, 1, 9258},
				{4, 7, 7558},
				{5, 6, 8196},
				{3, 4, 7284},
				{1, 5, 6327},
				{0, 4, 5966},
				{3, 6, 8575},
				{2, 5, 8604},
				{1, 7, 7782},
				{4, 6, 2857},
				{3, 7, 2336},
				{0, 6, 6},
				{5, 7, 2870},
				{4, 5, 5055},
				{0, 7, 2904},
				{1, 6, 2458},
				{0, 5, 3399},
				{6, 7, 2202},
				{0, 2, 3996},
				{0, 3, 7495},
				{1, 4, 2262},
				{2, 6, 1390}
			}, 7937)); //7

		System.out.println(new FindTheCityWithTheSmallestNumberOfNeighborsAtThresholdDistance().findTheCity(6, new int[][]
			{
				{0, 3, 7},
				{2, 4, 1},
				{0, 1, 5},
				{2, 3, 10},
				{1, 3, 6},
				{1, 2, 1}
			}, 417)); //5

		System.out.println(new FindTheCityWithTheSmallestNumberOfNeighborsAtThresholdDistance().findTheCity(5, new int[][]
			{
				{0, 1, 2},
				{0, 4, 8},
				{1, 2, 3},
				{1, 4, 2},
				{2, 3, 1},
				{3, 4, 1},
			}, 2)); //0

		System.out.println(new FindTheCityWithTheSmallestNumberOfNeighborsAtThresholdDistance().findTheCity(4, new int[][]
			{
				{0, 1, 3},
				{1, 2, 1},
				{1, 3, 4},
				{2, 3, 1},
			}, 4)); //3
	}
}
