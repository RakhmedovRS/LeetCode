import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 25-Jul-20
 */
@LeetCode(id = 1525, name = "Number of Good Ways to Split a String", url = "https://leetcode.com/problems/number-of-good-ways-to-split-a-string/")
public class NumberOfGoodWaysToSplitString
{
	public int numSplits(String s)
	{
		int[] left = new int[26];
		int[] right = new int[26];
		for (char ch : s.toCharArray())
		{
			right[ch - 'a']++;
		}

		int count = 0;
		for (int i = 0; i < s.length(); i++)
		{
			char ch = s.charAt(i);
			left[ch - 'a']++;
			right[ch - 'a']--;
			count += isSameNumber(left, right) ? 1 : 0;
		}

		return count;
	}

	private boolean isSameNumber(int[] left, int[] right)
	{
		int leftCount = 0;
		for (int lCount : left)
		{
			leftCount += lCount > 0 ? 1 : 0;
		}

		int rightCount = 0;
		for (int rCount : right)
		{
			rightCount += rCount > 0 ? 1 : 0;
		}

		return leftCount == rightCount;
	}
}
