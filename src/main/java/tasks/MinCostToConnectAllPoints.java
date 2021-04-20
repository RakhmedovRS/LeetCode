package tasks;

import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 13-Sep-20
 */
@LeetCode(id = 1584, name = "Min Cost to Connect All Points", url = "https://leetcode.com/problems/min-cost-to-connect-all-points/")
public class MinCostToConnectAllPoints
{
	class UnionFind
	{
		int[] index;
		int[] weight;

		public UnionFind(int size)
		{
			index = new int[size];
			weight = new int[size];
			for (int i = 0; i < size; i++)
			{
				index[i] = i;
				weight[i] = 1;
			}
		}

		private int parent(int node)
		{
			int parent = index[node];
			while (parent != index[parent])
			{
				parent = index[parent];
			}

			int temp = node;
			while (temp != index[temp])
			{
				temp = index[node];
				index[node] = parent;
				node = temp;
			}

			return parent;
		}

		private void unify(int nodeA, int nodeB)
		{
			int parentA = parent(nodeA);
			int parentB = parent(nodeB);

			if (parentA == parentB)
			{
				return;
			}

			if (weight[parentA] < weight[parentB])
			{
				weight[parentB] += weight[parentA];
				index[parentA] = parentB;
			}
			else
			{
				weight[parentA] += weight[parentB];
				index[parentB] = parentA;
			}
		}
	}

	public int minCostConnectPoints(int[][] points)
	{
		UnionFind unionFind = new UnionFind(points.length);
		PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[0]));
		for (int p1 = 0; p1 < points.length; p1++)
		{
			for (int p2 = p1 + 1; p2 < points.length; p2++)
			{
				int distance = Math.abs(points[p1][0] - points[p2][0]) + Math.abs(points[p1][1] - points[p2][1]);
				minHeap.add(new int[]{distance, p1, p2});
			}
		}

		int length = 0;
		while (!minHeap.isEmpty())
		{
			int[] edge = minHeap.remove();
			if (unionFind.parent(edge[1]) != unionFind.parent(edge[2]))
			{
				length += edge[0];
				unionFind.unify(edge[1], edge[2]);
			}
		}

		return length;
	}

	public static void main(String[] args)
	{
		System.out.println(new MinCostToConnectAllPoints().minCostConnectPoints(new int[][]
			{
				{0, 0},
				{2, 2},
				{3, 10},
				{5, 2},
				{7, 0}
			}));
	}
}
