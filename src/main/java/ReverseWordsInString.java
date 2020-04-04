import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 04-Apr-20
 */
@LeetCode(id = 151, name = "Reverse Words in a String", url = "https://leetcode.com/problems/reverse-words-in-a-string/")
public class ReverseWordsInString
{
	public String reverseWords(String s)
	{
		if (s == null || s.length() == 0)
		{
			return s;
		}

		String[] words = s.split(" ");
		StringBuilder result = new StringBuilder(words.length);
		for (int i = words.length - 1; i >= 0; i--)
		{
			if (words[i].length() != 0)
			{
				result.append(words[i]).append(" ");
			}
		}

		if (result.length() > 0)
		{
			result.deleteCharAt(result.length() - 1);
		}
		return result.toString();
	}

	public static void main(String[] args)
	{
		System.out.println(new ReverseWordsInString().reverseWords(""));
		System.out.println(new ReverseWordsInString().reverseWords(" "));
		System.out.println(new ReverseWordsInString().reverseWords("the sky is blue"));
		System.out.println(new ReverseWordsInString().reverseWords("  hello world!  "));
	}
}
