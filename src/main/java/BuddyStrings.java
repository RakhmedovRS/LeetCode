import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 9/26/2020
 */
@LeetCode(id = 859, name = "Buddy Strings", url = "https://leetcode.com/problems/buddy-strings/")
public class BuddyStrings
{
	public boolean buddyStrings(String A, String B)
	{
		if (A.length() != B.length())
		{
			return false;
		}

		if (A.equals(B))
		{
			int[] memo = new int[26];
			for (char ch : A.toCharArray())
			{
				if (memo[ch - 'a'] >= 1)
				{
					return true;
				}
				memo[ch - 'a']++;
			}

			return false;
		}
		else
		{
			List<Character> aList = new ArrayList<>();
			List<Character> bList = new ArrayList<>();
			for (int i = 0; i < A.length(); i++)
			{
				char aChar = A.charAt(i);
				char bChar = B.charAt(i);
				if (aChar != bChar)
				{
					aList.add(aChar);
					bList.add(bChar);
				}
			}

			return aList.size() == bList.size()
				&& aList.size() == 2
				&& aList.get(0).equals(bList.get(1))
				&& bList.get(0).equals(aList.get(1));
		}
	}

	public static void main(String[] args)
	{
		System.out.println(new BuddyStrings().buddyStrings("acccccb", "bccccca"));
		System.out.println(new BuddyStrings().buddyStrings("abcaa", "abcbb"));
		System.out.println(new BuddyStrings().buddyStrings("ab", "ab"));
		System.out.println(new BuddyStrings().buddyStrings("aa", "aa"));
		System.out.println(new BuddyStrings().buddyStrings("aaaaaaabc", "aaaaaaacb"));
	}
}
