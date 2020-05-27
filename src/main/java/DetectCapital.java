import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 27-May-20
 */
@LeetCode(id = 520, name = "Detect Capital", url = "")
public class DetectCapital
{
	public boolean detectCapitalUse(String word)
	{
		int capitalsCount = 0;
		for (int i = 0; i < word.length(); i++)
		{
			if (Character.isUpperCase(word.charAt(i)))
			{
				capitalsCount++;
			}
		}

		return capitalsCount == word.length()
			|| capitalsCount == 0
			|| (capitalsCount == 1 && Character.isUpperCase(word.charAt(0)));
	}
}
