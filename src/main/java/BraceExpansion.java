import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 1/16/2021
 */
@LeetCode(
	id = 1087,
	name = "Brace Expansion",
	url = "https://leetcode.com/problems/brace-expansion/",
	difficulty = Difficulty.MEDIUM,
	premium = true
)
public class BraceExpansion
{
	class Element
	{
		List<Character> chars;

		public Element(char ch)
		{
			chars = Arrays.asList(ch);
		}

		public Element(String[] subs)
		{
			chars = new ArrayList<>();
			char[] memo = new char[26];
			for (String sub : subs)
			{
				memo[sub.charAt(0) - 'a']++;
			}

			for (int i = 0; i < 26; i++)
			{
				while (memo[i]-- > 0)
				{
					chars.add((char) (i + 'a'));
				}
			}
		}
	}

	public String[] expand(String S)
	{
		List<Element> elements = new ArrayList<>();
		for (int i = 0; i < S.length(); )
		{
			Element element;
			if (S.charAt(i) == ',')
			{
				continue;
			}

			if (S.charAt(i) == '{')
			{
				int close = S.indexOf('}', i);
				element = new Element(S.substring(i + 1, close + 1).split(","));
				i = close + 1;
			}
			else
			{
				element = new Element(S.charAt(i));
				i += 1;
			}

			elements.add(element);
		}

		List<String> answer = new ArrayList<>();
		dfs(0, new StringBuilder(), elements, answer);

		return answer.toArray(new String[0]);
	}

	private void dfs(int pos, StringBuilder current, List<Element> elements, List<String> answer)
	{
		if (pos == elements.size())
		{
			answer.add(current.toString());
			return;
		}

		for (char ch : elements.get(pos).chars)
		{
			current.append(ch);
			dfs(pos + 1, current, elements, answer);
			current.deleteCharAt(current.length() - 1);
		}
	}

	public static void main(String[] args)
	{
		BraceExpansion clazz = new BraceExpansion();
		System.out.println(Arrays.toString(clazz.expand("{a,b}{z,x,y}")));
		System.out.println(Arrays.toString(clazz.expand("abcd")));
		System.out.println(Arrays.toString(clazz.expand("{a,b}c{d,e}f")));
	}
}
