import common.Difficulty;
import common.LeetCode;

import java.util.PriorityQueue;

/**
 * @author RakhmedovRS
 * @created 12/27/2020
 */
@LeetCode(
	id = 1705,
	name = "Maximum Number of Eaten Apples",
	url = "https://leetcode.com/problems/maximum-number-of-eaten-apples/",
	difficulty = Difficulty.MEDIUM
)
public class MaximumNumberOfEatenApples
{
	public int eatenApples(int[] apples, int[] days)
	{
		int eaten = 0;
		PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		int[] current;
		for (int i = 0; i < apples.length || !minHeap.isEmpty(); i++)
		{
			if (i < apples.length && apples[i] != 0)
			{
				minHeap.add(new int[]{apples[i], i + days[i]});
			}

			while (!minHeap.isEmpty() && i >= minHeap.peek()[1])
			{
				minHeap.remove();
			}

			if (!minHeap.isEmpty())
			{
				current = minHeap.remove();
				if (i >= apples.length && minHeap.isEmpty())
				{
					eaten += Math.min(current[0], Math.abs(i - current[1]));
					continue;
				}

				current[0]--;
				if (current[0] > 0)
				{
					minHeap.add(current);
				}

				eaten++;
			}
		}

		return eaten;
	}

	public static void main(String[] args)
	{
		MaximumNumberOfEatenApples clazz = new MaximumNumberOfEatenApples();
		System.out.println(clazz.eatenApples(new int[]{1, 2, 3, 5, 2}, new int[]{3, 2, 1, 4, 2}));
		System.out.println(clazz.eatenApples(new int[]{10_000}, new int[]{10_000}));
		System.out.println(clazz.eatenApples(new int[]{0}, new int[]{0}));
		System.out.println(clazz.eatenApples(new int[]{10}, new int[]{10}));
		System.out.println(clazz.eatenApples(new int[]{3, 0, 0, 0, 0, 2}, new int[]{3, 0, 0, 0, 0, 2}));
		System.out.println(clazz.eatenApples(new int[]{10, 0, 0, 0, 0, 0, 10}, new int[]{2, 0, 0, 0, 0, 0, 10}));
	}
}
