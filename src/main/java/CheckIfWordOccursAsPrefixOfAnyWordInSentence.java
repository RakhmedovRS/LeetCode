import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 05-Jun-20
 */
@LeetCode(id = 1455, name = "Check If a Word Occurs As a Prefix of Any Word in a Sentence", url = "https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/")
public class CheckIfWordOccursAsPrefixOfAnyWordInSentence
{
	public int isPrefixOfWord(String sentence, String searchWord)
	{
		String[] words = sentence.split(" ");
		for (int i = 0; i < words.length; i++)
		{
			String word = words[i];
			if (word.length() >= searchWord.length() && word.substring(0, searchWord.length()).equals(searchWord))
			{
				return i + 1;
			}
		}

		return -1;
	}
}
