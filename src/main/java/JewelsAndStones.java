import common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 14-Mar-20
 */
@LeetCode(id = 771, name = "Jewels and Stones", url = "https://leetcode.com/problems/jewels-and-stones/")
public class JewelsAndStones
{
	public int numJewelsInStones(String J, String S)
	{
		Set<Character> cache = new HashSet<>(J.length());
		for (char ch : J.toCharArray())
		{
			cache.add(ch);
		}

		int result = 0;
		for (char ch : S.toCharArray())
		{
			if (cache.contains(ch))
			{
				result++;
			}
		}
		return result;
	}

	public int numJewelsInStones1(String J, String S)
	{
		int[] capitalLetters = new int[26];
		int[] smallLetters = new int[26];
		for (char ch : J.toCharArray())
		{
			if (ch <= 'Z')
			{
				capitalLetters[ch - 'A']++;
			}
			else
			{
				smallLetters[(ch - 'a')]++;
			}
		}

		int result = 0;
		for (char ch : S.toCharArray())
		{
			if (ch <= 'Z')
			{
				if (capitalLetters[ch - 'A'] > 0)
				{
					result++;
				}
			}
			else
			{
				if (smallLetters[ch - 'a'] > 0)
				{
					result++;
				}
			}
		}
		return result;
	}

	public static void main(String[] args)
	{
		new JewelsAndStones().numJewelsInStones1("z", "ZZ");
	}
}
