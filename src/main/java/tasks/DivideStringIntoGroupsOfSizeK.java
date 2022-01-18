package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 1/18/2022
 */
@LeetCode(
	id = 2138,
	name = "Divide a String Into Groups of Size k",
	url = "https://leetcode.com/problems/divide-a-string-into-groups-of-size-k/",
	difficulty = Difficulty.EASY
)
public class DivideStringIntoGroupsOfSizeK
{
	public String[] divideString(String s, int k, char fill)
	{
		int pos = 0;
		List<String> list = new ArrayList<>();
		while (pos < s.length())
		{
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < k; i++)
			{
				if (pos < s.length())
				{
					sb.append(s.charAt(pos++));
				}
				else
				{
					sb.append(fill);
				}
			}

			list.add(sb.toString());
		}

		return list.toArray(new String[]{});
	}
}
