import common.Difficulty;
import common.LeetCode;

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
		int[] keyBoardPositions = new int[26];
		for (int i = 0; i < 26; i++)
		{
			keyBoardPositions[keyboard.charAt(i) - 'a'] = i;
		}

		int pos = 0;
		int cost = 0;
		for (char ch : word.toCharArray())
		{
			cost += Math.abs(pos - keyBoardPositions[ch - 'a']);
			pos = keyBoardPositions[ch - 'a'];
		}

		return cost;
	}
}
