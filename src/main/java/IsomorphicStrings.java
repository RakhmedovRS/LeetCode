import common.LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 11-Jul-20
 */
@LeetCode(id = 205, name = "Isomorphic Strings", url = "https://leetcode.com/problems/isomorphic-strings/")
public class IsomorphicStrings
{
	public boolean isIsomorphic(String s, String t)
	{
		Map<Character, Character> map = new HashMap<>();
		Set<Character> used = new HashSet<>();
		for (int i = 0; i < s.length(); i++)
		{
			if (map.get(s.charAt(i)) == null)
			{
				if (used.contains(t.charAt(i)))
				{
					return false;
				}
				used.add(t.charAt(i));
				map.put(s.charAt(i), t.charAt(i));
			}
			else
			{
				if (map.get(s.charAt(i)) != t.charAt(i))
				{
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args)
	{
		System.out.println(new IsomorphicStrings().isIsomorphic("ab", "aa"));
		System.out.println(new IsomorphicStrings().isIsomorphic("abba", "abab"));
		System.out.println(new IsomorphicStrings().isIsomorphic("egg", "add"));
		System.out.println(new IsomorphicStrings().isIsomorphic("foo", "bar"));
	}
}
