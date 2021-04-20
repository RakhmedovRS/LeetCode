package tasks;

import common.LeetCode;

import java.util.Arrays;
import java.util.Random;
import java.util.TreeMap;

/**
 * @author RakhmedovRS
 * @created 22-Aug-20
 */
@LeetCode(id = 497, name = "Random Point in Non-overlapping Rectangles", url = "https://leetcode.com/problems/random-point-in-non-overlapping-rectangles/")
public class RandomPointInNonOverlappingRectangles
{
	class Solution
	{
		private Random random;
		private TreeMap<Integer, int[]> treeMap;
		private int sum;

		public Solution(int[][] rects)
		{
			treeMap = new TreeMap<>();
			random = new Random();
			sum = 0;
			for (int[] rectangle : rects)
			{
				sum += calcArea(rectangle[0], rectangle[2], rectangle[1], rectangle[3]);
				treeMap.put(sum, rectangle);
			}
		}

		public int[] pick()
		{
			int[] rectangle = treeMap.ceilingEntry(random.nextInt(sum + 1)).getValue();
			int x = generatePoint(rectangle[0], rectangle[2]);
			int y = generatePoint(rectangle[1], rectangle[3]);
			return new int[]{x, y};
		}

		private int generatePoint(int lowerBound, int upperBound)
		{
			return lowerBound + random.nextInt(upperBound - lowerBound + 1);
		}

		private int calcArea(int x1, int x2, int y1, int y2)
		{
			return (1 + Math.abs(Math.abs(x1) - Math.abs(x2))) * (1 + Math.abs(Math.abs(y1) - Math.abs(y2)));
		}
	}

	public static void main(String[] args)
	{
		Solution solution = new RandomPointInNonOverlappingRectangles().new Solution(new int[][]
			{
				new int[]{-2, -2, -1, -1},
				new int[]{83793579, 18088559, 83793580, 18088560},
				new int[]{1, 0, 3, 0}
			});

		for (int i = 0; i < 10; i++)
		{
			System.out.println(Arrays.toString(solution.pick()));
		}

		System.out.println();
		solution = new RandomPointInNonOverlappingRectangles().new Solution(new int[][]
			{
				new int[]{1, 1, 5, 5}
			});

		for (int i = 0; i < 10; i++)
		{
			System.out.println(Arrays.toString(solution.pick()));
		}
	}
}
