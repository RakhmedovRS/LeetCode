import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 2/21/2021
 */
@LeetCode(
	id= 1768,
	name = "Merge Strings Alternately",
	url = "https://leetcode.com/problems/merge-strings-alternately/",
	difficulty = Difficulty.EASY
)
public class MergeStringsAlternately
{
	public String mergeAlternately(String word1, String word2)
	{
		StringBuilder sb = new StringBuilder();
		int i = 0;
		int j = 0;
		boolean first = true;
		while (i < word1.length() || j < word2.length())
		{
			if (i < word1.length() && j < word2.length())
			{
				if (first)
				{
					sb.append(word1.charAt(i++));
				}
				else
				{
					sb.append(word2.charAt(j++));
				}
			}
			else if (i < word1.length())
			{
				sb.append(word1.charAt(i++));
			}
			else
			{
				sb.append(word2.charAt(j++));
			}
			first = !first;
		}

		return sb.toString();
	}

	public static void main(String[] args)
	{
		MergeStringsAlternately clazz = new MergeStringsAlternately();
		System.out.println(clazz.mergeAlternately("abcd", "pq"));
		System.out.println(clazz.mergeAlternately("abcd", ""));
		System.out.println(clazz.mergeAlternately("", "pq"));
	}
}
