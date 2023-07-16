package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 2/14/2021
 */
@LeetCode(
		id = 1759,
		name = "Count Number of Homogenous Substrings",
		url = "https://leetcode.com/problems/count-number-of-homogenous-substrings/",
		difficulty = Difficulty.MEDIUM
)
public class CountNumberOfHomogenousSubstrings
{
	public int countHomogenous(String s)
	{
		int left = 0;
		int right = 0;
		long count = 0;
		char[] chars = s.toCharArray();
		int temp;
		int mod = 1_000_000_007;
		while (right < s.length())
		{
			temp = 0;
			while (right < s.length() && chars[left] == chars[right])
			{
				temp++;
				right++;
			}

			count = (count + (((long) temp * (temp + 1)) / 2) % mod) % mod;
			left = right;
		}

		return (int) count;
	}

	public static void main(String[] args)
	{
		CountNumberOfHomogenousSubstrings clazz = new CountNumberOfHomogenousSubstrings();
		System.out.println(clazz.countHomogenous("xy"));
		System.out.println(clazz.countHomogenous("zzzzz"));
		System.out.println(clazz.countHomogenous("abbcccaa"));
	}
}
