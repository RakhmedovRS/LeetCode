import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12/29/2020
 */
@LeetCode(
	id = 1062,
	name = "Longest Repeating Substring",
	url = "https://leetcode.com/problems/longest-repeating-substring/",
	difficulty = Difficulty.MEDIUM,
	premium = true
)
public class LongestRepeatingSubstring
{
	class Trie
	{
		Trie[] children = new Trie[26];
	}

	public int longestRepeatingSubstring(String s)
	{
		int max = 0;
		Trie root = new Trie();
		for (int i = 0; i < s.length(); i++)
		{
			max = Math.max(max, addToTrieAndCalcRepeats(root, i, s));
		}

		return max;
	}

	private int addToTrieAndCalcRepeats(Trie root, int startPos, String s)
	{
		int repeats = 0;
		boolean seeMismatch = false;
		int index;
		for (; startPos < s.length(); startPos++)
		{
			index = s.charAt(startPos) - 'a';
			if (root.children[index] == null)
			{
				seeMismatch = true;
				root.children[index] = new Trie();
			}

			if (!seeMismatch)
			{
				repeats++;
			}

			root = root.children[index];
		}

		return repeats;
	}
}
