import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 24-Jun-20
 */
@LeetCode(id = 791, name = "Custom Sort String", url = "https://leetcode.com/problems/custom-sort-string/")
public class CustomSortString
{
	public String customSortString(String S, String T)
	{
		int[] table = createTable(T);
		StringBuilder sorted = new StringBuilder();
		StringBuilder unused = new StringBuilder();
		for (char ch : S.toCharArray())
		{
			while (table[ch - 'a']-- > 0)
			{
				sorted.append(ch);
			}
		}

		for (char ch : T.toCharArray())
		{
			while (table[ch - 'a']-- > 0)
			{
				unused.append(ch);
			}
		}

		return sorted.append(unused).toString();
	}

	private int[] createTable(String string)
	{
		int[] table = new int[26];
		for (char ch : string.toCharArray())
		{
			table[ch - 'a']++;
		}
		return table;
	}
}
