package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 2/28/2021
 */
@LeetCode(
	id = 1773,
	name = "Count Items Matching a Rule",
	url = "https://leetcode.com/problems/count-items-matching-a-rule/",
	difficulty = Difficulty.EASY
)
public class CountItemsMatchingRule
{
	public int countMatches(List<List<String>> items, String ruleKey, String ruleValue)
	{
		int matches = 0;
		int index;
		if (ruleKey.equals("type"))
		{
			index = 0;
		}
		else if (ruleKey.equals("color"))
		{
			index = 1;
		}
		else
		{
			index = 2;
		}

		for (List<String> triplet : items)
		{
			if (ruleValue.equals(triplet.get(index)))
			{
				matches++;
			}
		}

		return matches;
	}

	public static void main(String[] args)
	{
		CountItemsMatchingRule clazz = new CountItemsMatchingRule();

		System.out.println(clazz.countMatches(Arrays.asList(
			Arrays.asList("phone", "blue", "pixel"),
			Arrays.asList("computer", "silver", "lenovo"),
			Arrays.asList("phone", "gold", "iphone")
		), "color", "silver"));

		System.out.println(clazz.countMatches(Arrays.asList(
			Arrays.asList("phone", "blue", "pixel"),
			Arrays.asList("computer", "silver", "lenovo"),
			Arrays.asList("phone", "gold", "iphone")
		), "type", "phone"));
	}
}
