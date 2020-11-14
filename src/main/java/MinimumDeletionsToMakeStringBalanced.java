import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11/14/2020
 */
@LeetCode(
	id = 1653,
	name = "Minimum Deletions to Make String Balanced",
	url = "https://leetcode.com/problems/minimum-deletions-to-make-string-balanced/",
	difficulty = Difficulty.MEDIUM
)
public class MinimumDeletionsToMakeStringBalanced
{
	public int minimumDeletions(String s)
	{
		int[] ab = new int[2];
		char[] chars = s.toCharArray();
		for (char ch : chars)
		{
			ab[ch - 'a']++;
		}

		int deletions = 0;
		int left = 0;
		int right = chars.length - 1;
		while (left < right)
		{
			if (ab[0] > 0 && chars[left] == 'a')
			{
				left++;
				ab[0]--;
			}
			else if (ab[1] > 0 && chars[right] == 'b')
			{
				right--;
				ab[1]--;
			}
			else
			{
				deletions++;
				if (ab[0] < ab[1])
				{
					ab[0]--;
					right--;
				}
				else
				{
					ab[1]--;
					left++;
				}
			}
		}

		return deletions;
	}

	public static void main(String[] args)
	{
		System.out.println(new MinimumDeletionsToMakeStringBalanced().minimumDeletions("baaaaaa"));
		System.out.println(new MinimumDeletionsToMakeStringBalanced().minimumDeletions("bbbbbba"));
		System.out.println(new MinimumDeletionsToMakeStringBalanced().minimumDeletions("aababbab"));
	}
}
