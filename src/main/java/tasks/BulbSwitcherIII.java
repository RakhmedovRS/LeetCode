package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11/10/2020
 */
@LeetCode(id = 1375, name = "Bulb Switcher III", url = "https://leetcode.com/problems/bulb-switcher-iii/")
public class BulbSwitcherIII
{
	public int numTimesAllBlue(int[] light)
	{
		char[] line = new char[50_002];
		int moments = 0;
		int max = 0;
		for (int k : light)
		{
			max = Math.max(max, k);
			line[k] = 'E';
			if (k - 1 == 0 || line[k - 1] == 'B')
			{
				line[k] = 'B';
			}

			if (line[k] == 'B')
			{
				while (k + 1 < line.length && line[k + 1] == 'E')
				{
					line[++k] = 'B';
				}
			}

			if (k == max && line[k] == 'B')
			{
				moments++;
			}
		}

		return moments;
	}

	public static void main(String[] args)
	{
		System.out.println(new BulbSwitcherIII().numTimesAllBlue(new int[]{2, 1, 3, 5, 4})); //3
		System.out.println(new BulbSwitcherIII().numTimesAllBlue(new int[]{3, 2, 4, 1, 5})); //2
		System.out.println(new BulbSwitcherIII().numTimesAllBlue(new int[]{4, 1, 2, 3})); //1
		System.out.println(new BulbSwitcherIII().numTimesAllBlue(new int[]{2, 1, 4, 3, 6, 5})); //3
		System.out.println(new BulbSwitcherIII().numTimesAllBlue(new int[]{1, 2, 3, 4, 5, 6})); //6
	}
}
