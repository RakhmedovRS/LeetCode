package tasks;

import common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 28-Jun-20
 */
@LeetCode(id = 1496, name = "Path Crossing", url = "https://leetcode.com/problems/path-crossing/")
public class PathCrossing
{
	public boolean isPathCrossing(String path)
	{
		Set<String> set = new HashSet<>();
		int x = 0;
		int y = 0;
		set.add("0_0");
		for (char ch : path.toCharArray())
		{
			if (ch == 'N')
			{
				y++;
			}
			else if (ch == 'S')
			{
				y--;
			}
			else if (ch == 'E')
			{
				x++;
			}
			else if (ch == 'W')
			{
				x--;
			}

			if (!set.add(x + "_" + y))
			{
				return true;
			}
		}

		return false;
	}
}
