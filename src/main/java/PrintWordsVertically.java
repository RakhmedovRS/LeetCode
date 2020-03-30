import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 08-Mar-20
 */
@LeetCode(id = 1324, name = "Print Words Vertically", url = "https://leetcode.com/problems/print-words-vertically/")
public class PrintWordsVertically
{
	public List<String> printVertically(String s)
	{
		if (s == null || "".equals(s))
		{
			return new ArrayList<>();
		}

		String[] words = s.split(" ");
		int maxLength = 0;
		for (String word : words)
		{
			maxLength = Math.max(maxLength, word.length());
		}

		List<String> result = new ArrayList<>(maxLength);

		StringBuilder temp;
		for (int i = 0; i < maxLength; i++)
		{
			temp = new StringBuilder();
			for (String word : words)
			{
				if (i <= word.length() - 1)
				{
					temp.append(word.charAt(i));
				}
				else
				{
					temp.append(" ");
				}
			}

			while (temp.length() != 0 && temp.charAt(temp.length() - 1) == ' ')
			{
				temp.deleteCharAt(temp.length() - 1);
			}

			result.add(temp.toString());
		}

		return result;
	}

	public static void main(String[] args)
	{
		System.out.println(new PrintWordsVertically().printVertically("HOW ARE YOU"));
	}
}
