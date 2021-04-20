package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author RakhmedovRS
 * @created 3/21/2021
 */
@LeetCode(
	id = 1801,
	name = "Number of Orders in the Backlog",
	url = "https://leetcode.com/problems/number-of-orders-in-the-backlog/",
	difficulty = Difficulty.MEDIUM
)
public class NumberOfOrdersInTheBacklog
{
	public int getNumberOfBacklogOrders(int[][] orders)
	{
		PriorityQueue<int[]> buys = new PriorityQueue<>((a, b) -> b[0] - a[0]);
		PriorityQueue<int[]> sells = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
		for (int[] order : orders)
		{
			//buy
			if (order[2] == 0)
			{
				while (order[1] > 0 && !sells.isEmpty() && sells.peek()[0] <= order[0])
				{
					int[] sellOrder = sells.remove();
					int min = Math.min(sellOrder[1], order[1]);
					order[1] -= min;
					sellOrder[1] -= min;
					if (sellOrder[1] > 0)
					{
						sells.add(sellOrder);
					}
				}

				if (order[1] > 0)
				{
					buys.add(order);
				}
			}
			//sell
			else
			{
				while (order[1] > 0 && !buys.isEmpty() && buys.peek()[0] >= order[0])
				{
					int[] buyOrder = buys.remove();
					int min = Math.min(buyOrder[1], order[1]);
					order[1] -= min;
					buyOrder[1] -= min;
					if (buyOrder[1] > 0)
					{
						buys.add(buyOrder);
					}
				}

				if (order[1] > 0)
				{
					sells.add(order);
				}
			}
		}

		long count = 0;
		for (int[] order : buys)
		{
			count += order[1];
			count %= 1_000_000_007;
		}

		for (int[] order : sells)
		{
			count += order[1];
			count %= 1_000_000_007;
		}

		return (int) count;
	}

	public static void main(String[] args)
	{
		NumberOfOrdersInTheBacklog clazz = new NumberOfOrdersInTheBacklog();

		System.out.println(clazz.getNumberOfBacklogOrders(new int[][]
			{
				{26, 7, 0},
				{16, 1, 1},
				{14, 20, 0},
				{23, 15, 1},
				{24, 26, 0},
				{19, 4, 1},
				{1, 1, 0},
			}));

		System.out.println(clazz.getNumberOfBacklogOrders(new int[][]
			{
				{7, 1000000000, 1},
				{15, 3, 0},
				{5, 999999995, 0},
				{5, 1, 1}
			}));

		System.out.println(clazz.getNumberOfBacklogOrders(new int[][]
			{
				{10, 5, 0},
				{15, 2, 1},
				{25, 1, 1},
				{30, 4, 0}
			}));
	}
}
