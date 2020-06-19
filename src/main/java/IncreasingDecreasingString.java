import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 19-Jun-20
 */
@LeetCode(id = 1370, name = "Increasing Decreasing String", url = "https://leetcode.com/problems/increasing-decreasing-string/")
public class IncreasingDecreasingString
{
	public String sortString(String s)
	{
		int[] chars = new int[26];
		for (char ch : s.toCharArray())
		{
			chars[ch - 'a']++;
		}

		StringBuilder stringBuilder = new StringBuilder(chars.length);
		while (containsValues(chars))
		{
			int smallest = 0;
			while (chars[smallest] == 0)
			{
				smallest++;
			}

			stringBuilder.append((char) (smallest + 'a'));
			chars[smallest]--;

			smallest++;
			while (smallest < 26)
			{
				if (chars[smallest] > 0)
				{
					chars[smallest]--;
					stringBuilder.append((char) (smallest + 'a'));
				}
				smallest++;
			}

			int biggest = 25;
			while (biggest >= 0 && chars[biggest] == 0)
			{
				biggest--;
			}

			if (biggest >= 0)
			{
				chars[biggest]--;
				stringBuilder.append((char) (biggest + 'a'));
			}

			biggest--;
			while (biggest >= 0)
			{
				if (chars[biggest] > 0)
				{
					chars[biggest]--;
					stringBuilder.append((char) (biggest + 'a'));
				}
				biggest--;
			}
		}

		return stringBuilder.toString();
	}

	private boolean containsValues(int[] chars)
	{
		for (int aChar : chars)
		{
			if (aChar != 0)
			{
				return true;
			}
		}

		return false;
	}
}
