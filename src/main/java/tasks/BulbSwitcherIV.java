package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 26-Jul-20
 */
@LeetCode(id = 1529, name = "Bulb Switcher IV", url = "https://leetcode.com/problems/bulb-switcher-iv/")
public class BulbSwitcherIV
{
	public int minFlips(String target)
	{
		int flip = 0;
		int current = 0;
		for (char ch : target.toCharArray())
		{
			int state = ch - '0';
			if (current != state)
			{
				flip++;
				current = (current + 1) % 2;
			}
		}

		return flip;
	}
}
