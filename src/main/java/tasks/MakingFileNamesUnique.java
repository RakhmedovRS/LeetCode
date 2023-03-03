package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 21-Jun-20
 */
@LeetCode(
		id = 1487,
		name = "Making File Names Unique",
		url = "https://leetcode.com/problems/making-file-names-unique/",
		difficulty = Difficulty.MEDIUM
)
public class MakingFileNamesUnique
{
	public String[] getFolderNames(String[] names)
	{
		Map<String, Integer> set = new HashMap<>(names.length);
		String[] unique = new String[names.length];
		for (int i = 0; i < names.length; i++)
		{
			String name = names[i];
			int count = set.getOrDefault(name, 0);
			if (count > 0)
			{
				while (set.containsKey(name.concat("(").concat(String.valueOf(count).concat(")"))))
				{
					count++;
				}
				unique[i] = name.concat("(").concat(String.valueOf(count).concat(")"));
				set.put(name, count);
				set.put(unique[i], 1);
			}
			else
			{
				unique[i] = name;
				set.put(name, 1);
			}
		}

		return unique;
	}
}
