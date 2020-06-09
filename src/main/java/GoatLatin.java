import common.LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 09-Jun-20
 */
@LeetCode(id = 824, name = "Goat Latin", url = "https://leetcode.com/problems/goat-latin/")
public class GoatLatin
{
	public String toGoatLatin(String S)
	{
		Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

		StringBuilder result = new StringBuilder();
		StringBuilder a = new StringBuilder("a");
		for (String string : S.split(" "))
		{

			if (vowels.contains(string.charAt(0)))
			{
				result.append(string);
			}
			else
			{
				result.append(string.substring(1));
				result.append(string, 0, 1);
			}
			result.append("ma");
			result.append(a);
			result.append(" ");
			a.append("a");
		}

		if (result.length() != 0)
		{
			result.deleteCharAt(result.length() - 1);
		}

		return result.toString();
	}

	public static void main(String[] args)
	{
		System.out.println(new GoatLatin().toGoatLatin("I speak Goat Latin"));
	}
}
