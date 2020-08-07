import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 07-Aug-20
 */
@LeetCode(id = 752, name = "Open the Lock", url = "https://leetcode.com/problems/open-the-lock/")
public class OpenTheLock
{
	public int openLock(String[] deadends, String target)
	{
		Set<Integer> deadTable = new HashSet<>();
		for (String deadend : deadends)
		{
			int num = 0;
			for (int i = 0; i < 4; i++)
			{
				num *= 10;
				num += deadend.charAt(i) - '0';
			}
			deadTable.add(num);
		}

		if (deadTable.contains(0))
		{
			return -1;
		}

		int[] start = new int[]{
			target.charAt(0) - '0',
			target.charAt(1) - '0',
			target.charAt(2) - '0',
			target.charAt(3) - '0'
		};

		if (deadTable.contains(convertToNumber(start)))
		{
			return -1;
		}

		Queue<int[]> combinations = new LinkedList<>();
		combinations.add(start);
		int size;
		int steps = 0;
		Set<Integer> visited = new HashSet<>();
		while (!combinations.isEmpty())
		{
			size = combinations.size();
			while (size-- > 0)
			{
				int[] current = combinations.remove();
				if (!visited.add(convertToNumber(current)))
				{
					continue;
				}

				for (int pos = 0; pos < 4; pos++)
				{
					int[] next = Arrays.copyOf(current, 4);
					next[pos]--;
					if (next[pos] < 0)
					{
						next[pos] = 9;
					}

					if (next[0] == 0 && next[1] == 0 && next[2] == 0 && next[3] == 0)
					{
						return steps + 1;
					}

					int newNum = convertToNumber(next);
					if (!deadTable.contains(newNum) && !visited.contains(newNum))
					{
						combinations.add(next);
					}

					next = Arrays.copyOf(current, 4);
					next[pos]++;
					if (next[pos] > 9)
					{
						next[pos] = 0;
					}

					if (next[0] == 0 && next[1] == 0 && next[2] == 0 && next[3] == 0)
					{
						return steps + 1;
					}

					newNum = convertToNumber(next);
					if (!deadTable.contains(newNum) && !visited.contains(newNum))
					{
						combinations.add(next);
					}
				}
			}
			steps++;
		}

		return -1;
	}

	private int convertToNumber(int[] digits)
	{
		int num = 0;
		for (int i = 0; i < 4; i++)
		{
			num *= 10;
			num += digits[i];
		}
		return num;
	}
}
