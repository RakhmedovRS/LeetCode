import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12-Jun-20
 */
@LeetCode(id = 1160, name = "Find Words That Can Be Formed by Characters", url = "https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/")
public class FindWordsThatCanBeFormedByCharacters
{
	public int countCharacters(String[] words, String chars)
	{
		int[] dictionary = createDictionary(chars);

		int count = 0;
		for (String word : words)
		{
			if (isPossibleToCreateWord(dictionary, createDictionary(word)))
			{
				count+=word.length();
			}
		}

		return count;
	}

	private int[] createDictionary(String chars)
	{
		int[] dictionary = new int[26];
		for (char ch : chars.toCharArray())
		{
			dictionary[ch - 'a']++;
		}
		return dictionary;
	}

	private boolean isPossibleToCreateWord(int[] dictionary, int[] wordDict)
	{
		for (int i = 0; i < dictionary.length; i++)
		{
			if (wordDict[i] > dictionary[i])
			{
				return false;
			}
		}

		return true;
	}
}
