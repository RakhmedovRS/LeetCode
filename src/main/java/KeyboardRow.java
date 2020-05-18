import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 18-May-20
 */
@LeetCode(id = 500, name = "Keyboard Row", url = "https://leetcode.com/problems/keyboard-row/")
public class KeyboardRow
{
	public String[] findWords(String[] words)
	{
		List<Set<Character>> lines = getLines();
		List<String> oneLineWords = new ArrayList<>();

		for (String word : words)
		{
			for (Set<Character> set : lines)
			{
				if (contains(set, word))
				{
					oneLineWords.add(word);
					break;
				}
			}
		}


		String[] result = new String[oneLineWords.size()];
		for (int i = 0; i < oneLineWords.size(); i++)
		{
			result[i] = oneLineWords.get(i);
		}

		return result;
	}

	private List<Set<Character>> getLines()
	{
		Set<Character> line1 = new HashSet<>();
		for (char ch : "qwertyuiop".toCharArray())
		{
			line1.add(ch);
			line1.add((char) (ch - 32));
		}

		Set<Character> line2 = new HashSet<>();
		for (char ch : "asdfghjkl".toCharArray())
		{
			line2.add(ch);
			line2.add((char) (ch - 32));
		}

		Set<Character> line3 = new HashSet<>();
		for (char ch : "zxcvbnm".toCharArray())
		{
			line3.add(ch);
			line3.add((char) (ch - 32));
		}

		return Arrays.asList(line1, line2, line3);
	}

	private boolean contains(Set<Character> set, String word)
	{
		for (char ch : word.toCharArray())
		{
			if (!set.contains(ch))
			{
				return false;
			}
		}

		return true;
	}
}
