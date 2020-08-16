import common.LeetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 16-Aug-20
 */
@LeetCode(id = 1553, name = "Minimum Number of Days to Eat N Oranges", url = "https://leetcode.com/problems/minimum-number-of-days-to-eat-n-oranges/")
public class MinimumNumberOfDaysToEatNOranges
{
	public int minDays(int n)
	{
		LinkedList<Integer> list = new LinkedList<>();
		list.add(n);
		Set<Integer> visited = new HashSet<>();
		int days = 0;
		int size;
		while (!list.isEmpty())
		{
			size = list.size();
			while (size-- > 0)
			{
				int val = list.removeFirst();
				if (!visited.add(val))
				{
					continue;
				}

				if (val % 3 == 0)
				{
					list.addLast(val - 2*(val/3));
				}

				if (val % 2 == 0)
				{
					list.addLast(val / 2);
				}

				if (val - 1 == 0)
				{
					return days + 1;
				}
				list.add(val - 1);
			}
			days++;
		}

		return days;
	}

	public static void main(String[] args)
	{
		System.out.println(new MinimumNumberOfDaysToEatNOranges().minDays(84806671));
		System.out.println(new MinimumNumberOfDaysToEatNOranges().minDays(22479359));
		System.out.println(new MinimumNumberOfDaysToEatNOranges().minDays(61455274));
		System.out.println(new MinimumNumberOfDaysToEatNOranges().minDays(834827));
		System.out.println(new MinimumNumberOfDaysToEatNOranges().minDays(10));
		System.out.println(new MinimumNumberOfDaysToEatNOranges().minDays(6));
		System.out.println(new MinimumNumberOfDaysToEatNOranges().minDays(820592));
		System.out.println(new MinimumNumberOfDaysToEatNOranges().minDays(56));
		System.out.println(new MinimumNumberOfDaysToEatNOranges().minDays(1));
	}
}
