import common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 20-Sep-20
 */
@LeetCode(id = 1593, name = "Split a String Into the Max Number of Unique Substrings", url = "https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/")
public class SplitStringIntoTheMaxNumberOfUniqueSubstrings
{
	public int maxUniqueSplit(String s)
	{
		Set<String> set = new HashSet<>();
		int[] max = new int[]{0};
		dfs(s, 0, new HashSet<>(), max);
		return max[0];
	}

	private void dfs(String s, int start, Set<String> set, int[] max)
	{
		if (start >= s.length())
		{
			max[0] = Math.max(max[0], set.size());
			return;
		}

		String sub;
		for (int i = start + 1; i <= s.length(); i++)
		{
			sub = s.substring(start, i);
			if (set.add(sub))
			{
				dfs(s, i, set, max);
				set.remove(sub);
			}
		}
	}
}
