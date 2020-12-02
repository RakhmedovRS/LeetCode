import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 12/2/2020
 */
@LeetCode(
	id = 1165,
	name = "Single-Row Keyboard",
	url = "https://leetcode.com/problems/single-row-keyboard/",
	difficulty = Difficulty.EASY,
	premium = true
)
public class SingleRowKeyboard
{
	public int calculateTime(String keyboard, String word)
	{
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < keyboard.length(); i++)
		{
			map.put(keyboard.charAt(i), i);
		}

		int prevPos = 0;
		int currPos;
		int sum = 0;
		for (char ch : word.toCharArray())
		{
			currPos = map.get(ch);
			sum += Math.abs(prevPos - currPos);
			prevPos = currPos;
		}

		return sum;
	}
}
