import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 19-May-20
 */
@LeetCode(id = 917, name = "Reverse Only Letters", url = "https://leetcode.com/problems/reverse-only-letters/")
public class ReverseOnlyLetters
{
	public String reverseOnlyLetters(String S)
	{
		if (S == null || S.isEmpty())
		{
			return S;
		}

		int left = 0;
		int right = S.length() - 1;
		char[] chars = S.toCharArray();
		while (left < right)
		{
			while (left < S.length() && !Character.isAlphabetic(chars[left]))
			{
				left++;
			}

			if (left >= right)
			{
				break;
			}

			while (right >= 0 && !Character.isAlphabetic(chars[right]))
			{
				right--;
			}

			if (left >= right)
			{
				break;
			}

			char temp = chars[left];
			chars[left] = chars[right];
			chars[right] = temp;
			left++;
			right--;
		}

		return String.valueOf(chars);
	}
}
