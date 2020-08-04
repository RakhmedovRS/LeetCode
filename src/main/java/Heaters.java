import common.LeetCode;

import java.util.TreeSet;

/**
 * @author RakhmedovRS
 * @created 04-Aug-20
 */
@LeetCode(id = 475, name = "Heaters", url = "https://leetcode.com/problems/heaters/")
public class Heaters
{
	public int findRadius(int[] houses, int[] heaters)
	{
		TreeSet<Integer> treeSet = new TreeSet<>();
		for (int heater : heaters)
		{
			treeSet.add(heater);
		}

		int max = 0;
		for (int house : houses)
		{
			Integer ceil = treeSet.ceiling(house);
			Integer floor = treeSet.floor(house);
			max = Math.max(max,
				Math.min(ceil == null ? Integer.MAX_VALUE : ceil - house,
					floor == null ? Integer.MAX_VALUE : house - floor));
		}
		return max;
	}
}
