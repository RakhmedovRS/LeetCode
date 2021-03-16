import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 3/14/2021
 */
@LeetCode(
	id = 1790,
	name = "Check if One String Swap Can Make Strings Equal",
	url = "https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/",
	difficulty = Difficulty.EASY
)
public class CheckIfOneStringSwapCanMakeStringsEqual
{
	public boolean areAlmostEqual(String s1, String s2)
	{
		if (s1.equals(s2))
		{
			return true;
		}

		char[] charsA = s1.toCharArray();
		char[] charsB = s2.toCharArray();

		int[] memo = new int[26];
		for (char i = 0; i < charsA.length; i++)
		{
			memo[charsA[i] - 'a']++;
			memo[charsB[i] - 'a']--;
		}

		for (int i = 0; i < 26; i++)
		{
			if (memo[i] != 0)
			{
				return false;
			}
		}

		for (int i = 0; i < s1.length(); i++)
		{
			for (int j = i + 1; j < s1.length(); j++)
			{
				swap(charsA, i, j);
				swap(charsB, i, j);
				if (String.valueOf(charsA).equals(s2) || String.valueOf(charsB).equals(s1))
				{
					return true;
				}
				swap(charsA, i, j);
				swap(charsB, i, j);
			}
		}

		return false;
	}

	private void swap(char[] chars, int a, int b)
	{
		char temp = chars[a];
		chars[a] = chars[b];
		chars[b] = temp;
	}

	public static void main(String[] args)
	{
		CheckIfOneStringSwapCanMakeStringsEqual clazz = new CheckIfOneStringSwapCanMakeStringsEqual();
		System.out.println(clazz.areAlmostEqual("bank", "kanb"));
		System.out.println(clazz.areAlmostEqual("attack", "defend"));
		System.out.println(clazz.areAlmostEqual("abcd", "dcba"));
	}
}
