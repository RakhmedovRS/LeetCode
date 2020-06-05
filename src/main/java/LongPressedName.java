import common.LeetCode;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 05-Jun-20
 */
@LeetCode(id = 926, name = "Long Pressed Name", url = "https://leetcode.com/problems/long-pressed-name/")
public class LongPressedName
{
	public boolean isLongPressedName(String name, String typed)
	{
		List<Pair<Character, Integer>> namePairs = shortString(name);
		List<Pair<Character, Integer>> typedPairs = shortString(typed);
		if (namePairs.size() != typedPairs.size())
		{
			return false;
		}

		for (int i = 0; i < namePairs.size(); i++)
		{
			Pair<Character, Integer> namePair = namePairs.get(i);
			Pair<Character, Integer> typedPair = typedPairs.get(i);

			if (namePair.getKey() != typedPair.getKey() || namePair.getValue() > typedPair.getValue())
			{
				return false;
			}
		}

		return true;
	}

	private List<Pair<Character, Integer>> shortString(String string)
	{
		List<Pair<Character, Integer>> pairs = new ArrayList<>();
		char prev = string.charAt(0);
		int count = 0;
		for (int i = 0; i < string.length(); i++)
		{
			if (string.charAt(i) == prev)
			{
				count++;
			}
			else
			{
				pairs.add(new Pair<>(prev, count));
				prev = string.charAt(i);
				count = 0;
			}
		}
		pairs.add(new Pair<>(prev, count));

		return pairs;
	}
}
