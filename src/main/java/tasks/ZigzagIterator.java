package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.List;

/**
 * @author RakhmedovRS
 * @created 12/16/2020
 */
@LeetCode(
		id = 281,
		name = "Zigzag Iterator",
		url = "https://leetcode.com/problems/zigzag-iterator/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class ZigzagIterator
{

	int pos1;
	int pos2;
	List<Integer> v1;
	List<Integer> v2;

	public ZigzagIterator(List<Integer> v1, List<Integer> v2)
	{
		this.v1 = v1;
		this.v2 = v2;
	}

	public int next()
	{
		if (pos1 <= pos2)
		{
			if (pos1 == v1.size())
			{
				return v2.get(pos2++);
			}
			else
			{
				return v1.get(pos1++);
			}
		}
		else
		{
			if (pos2 == v2.size())
			{
				return v1.get(pos1++);
			}
			else
			{
				return v2.get(pos2++);
			}
		}
	}

	public boolean hasNext()
	{
		return pos1 < v1.size() || pos2 < v2.size();
	}
}
