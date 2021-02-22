import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 24-Jun-20
 */
@LeetCode(
	id = 720,
	name = "Longest Word in Dictionary",
	url = "https://leetcode.com/problems/longest-word-in-dictionary/",
	difficulty = Difficulty.EASY
)
public class LongestWordInDictionary
{
	class Trie
	{
		Trie[] children = new Trie[26];
		boolean end;
	}

	private void addToTrie(Trie root, char[] chars)
	{
		for (char ch : chars)
		{
			if (root.children[ch - 'a'] == null)
			{
				root.children[ch - 'a'] = new Trie();
			}

			root = root.children[ch - 'a'];
		}
		root.end = true;
	}

	public String longestWord(String[] words)
	{
		Trie root = new Trie();
		for (String word : words)
		{
			addToTrie(root, word.toCharArray());
		}

		String[] answer = new String[]{""};
		dfs(root, new StringBuilder(), answer);

		return answer[0];
	}

	private void dfs(Trie root, StringBuilder sb, String[] answer)
	{
		if (root == null)
		{
			return;
		}

		if (sb.length() > answer[0].length())
		{
			answer[0] = sb.toString();
		}
		else if (sb.length() == answer[0].length())
		{
			String temp = sb.toString();
			if (temp.compareTo(answer[0]) < 0)
			{
				answer[0] = temp;
			}
		}

		for (int i = 0; i < root.children.length; i++)
		{
			if (root.children[i] != null && root.children[i].end)
			{
				sb.append((char) (i + 'a'));
				dfs(root.children[i], sb, answer);
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}

	public static void main(String[] args)
	{
		LongestWordInDictionary clazz = new LongestWordInDictionary();
		System.out.println(clazz.longestWord(new String[]{"yo", "ew", "fc", "zrc", "yodn", "fcm", "qm", "qmo", "fcmz", "z", "ewq", "yod", "ewqz", "y"}));
		System.out.println(clazz.longestWord(new String[]{"b", "br", "bre", "brea", "break", "breakf", "breakfa", "breakfas", "breakfast", "l", "lu", "lun", "lunc", "lunch", "d", "di", "din", "dinn", "dinne", "dinner"}));
		System.out.println(clazz.longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}));
	}
}
