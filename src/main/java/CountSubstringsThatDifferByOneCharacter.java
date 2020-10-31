import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 10/31/2020
 */
@LeetCode(id = 1638, name = "Count Substrings That Differ by One Character", url = "https://leetcode.com/problems/count-substrings-that-differ-by-one-character/")
public class CountSubstringsThatDifferByOneCharacter
{
	class Trie
	{
		Trie[] children = new Trie[26];
		int ends;
	}

	public int countSubstrings(String s, String t)
	{
		int answer = 0;
		Trie root = buildTrie(t);
		char[] sub;
		char exclude;
		for (int length = 1; length <= s.length(); length++)
		{
			for (int i = 0; i + length <= s.length(); i++)
			{
				sub = s.substring(i, i + length).toCharArray();
				for (int pos = 0; pos < sub.length; pos++)
				{
					exclude = sub[pos];
					for (char ch = 'a'; ch <= 'z'; ch++)
					{
						if (ch != exclude)
						{
							sub[pos] = ch;
							answer += count(root, sub);
						}
					}
					sub[pos] = exclude;
				}
			}
		}

		return answer;
	}

	private Trie buildTrie(String target)
	{
		Trie root = new Trie();
		char ch;
		for (int length = 1; length <= target.length(); length++)
		{
			for (int i = 0; i + length <= target.length(); i++)
			{
				Trie current = root;
				for (int j = 0; j < length; j++)
				{
					ch = target.charAt(i + j);
					if (current.children[ch - 'a'] == null)
					{
						current.children[ch - 'a'] = new Trie();
					}
					current = current.children[ch - 'a'];
				}
				current.ends++;
			}
		}

		return root;
	}

	private int count(Trie trie, char[] chars)
	{
		for (char ch : chars)
		{
			if (trie.children[ch - 'a'] == null)
			{
				return 0;
			}
			trie = trie.children[ch - 'a'];
		}

		return trie.ends;
	}
}
