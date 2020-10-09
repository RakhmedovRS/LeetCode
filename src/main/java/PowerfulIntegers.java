import common.LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 10/9/2020
 */
@LeetCode(id = 970, name = "Powerful Integers", url = "https://leetcode.com/problems/powerful-integers/")
public class PowerfulIntegers
{
	public List<Integer> powerfulIntegers(int x, int y, int bound)
	{
		Set<Integer> answer = new HashSet<>();
		long a;
		long b;
		for (int i = 0; i < 31; i++)
		{
			a = (long) Math.pow(x, i);
			if (a > bound)
			{
				break;
			}

			for (int j = 0; j < 31; j++)
			{
				b = (long) Math.pow(y, j);
				if (a + b > bound)
				{
					break;
				}

				answer.add((int) (a + b));
			}
		}

		return new ArrayList<>(answer);
	}
}
