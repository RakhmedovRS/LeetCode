package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 12/28/2020
 */
@LeetCode(
	id = 1093,
	name = "Statistics from a Large Sample",
	url = "https://leetcode.com/problems/statistics-from-a-large-sample/",
	difficulty = Difficulty.MEDIUM
)
public class StatisticsFromLargeSample
{
	public double[] sampleStats(int[] count)
	{
		double min = Double.MAX_VALUE;
		double max = Double.MIN_VALUE;
		double sum = 0;
		int mean = 0;
		int numbersCount = 0;
		for (int i = 0; i < count.length; i++)
		{
			if (count[i] != 0)
			{
				min = Math.min(min, i);
				max = Math.max(min, i);
				numbersCount += count[i];
				if (count[i] > count[mean])
				{
					mean = i;
				}
			}
		}

		int elements = 0;
		double sumOfMiddle = 0;
		for (int i = 0; i < count.length; i++)
		{
			if (count[i] != 0)
			{
				sum += count[i] * i;
				if (numbersCount % 2 == 0)
				{
					if (elements < numbersCount / 2 && elements + count[i] > numbersCount / 2)
					{
						sumOfMiddle += i * 2;
					}
					else if ((elements <= (numbersCount / 2) && elements + count[i] >= (numbersCount / 2) - 1))
					{
						sumOfMiddle += i;
					}
				}
				else
				{
					if (elements < numbersCount / 2 && elements + count[i] >= numbersCount / 2)
					{
						sumOfMiddle += i;
					}
				}

				elements += count[i];
			}
		}

		double median = numbersCount % 2 == 0 ? sumOfMiddle / 2 : sumOfMiddle;

		return new double[]{min, max, sum / numbersCount, median, mean};
	}

	public static void main(String[] args)
	{
		StatisticsFromLargeSample clazz = new StatisticsFromLargeSample();

		System.out.println(Arrays.toString(clazz.sampleStats(new int[]{0, 1, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0})));

		System.out.println(Arrays.toString(clazz.sampleStats(new int[]
			{264, 912, 1416, 1903, 2515, 3080, 3598, 4099, 4757, 5270, 5748, 6451, 7074, 7367, 7847, 8653, 9318, 9601, 10481, 10787,
				11563, 11869, 12278, 12939, 13737, 13909, 14621, 15264, 15833, 16562, 17135, 17491, 17982, 18731, 19127, 19579,
				20524, 20941, 21347, 21800, 22342, 21567, 21063, 20683, 20204, 19818, 19351, 18971, 18496, 17974, 17677, 17034,
				16701, 16223, 15671, 15167, 14718, 14552, 14061, 13448, 13199, 12539, 12265, 11912, 10931, 10947, 10516, 10177,
				9582, 9102, 8699, 8091, 7864, 7330, 6915, 6492, 6013, 5513, 5140, 4701, 4111, 3725, 3321, 2947, 2357, 1988, 1535,
				1124, 664, 206, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0})))
		;

		System.out.println(Arrays.toString(clazz.sampleStats(new int[]
			{0, 4, 3, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0})));
	}
}
