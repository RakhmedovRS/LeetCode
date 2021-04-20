package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 12/12/2020
 */
@LeetCode(
	id = 833,
	name = "Find And Replace in String",
	url = "https://leetcode.com/problems/find-and-replace-in-string/",
	difficulty = Difficulty.MEDIUM
)
public class FindAndReplaceInString
{
	public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets)
	{
		StringBuilder sb = new StringBuilder();
		Map<Integer, String[]> map = new HashMap<>();
		for (int i = 0; i < indexes.length; i++)
		{
			map.put(indexes[i], new String[]{sources[i], targets[i]});
		}

		String[] pair;
		String source;
		String target;
		for (int i = 0; i < S.length(); i++)
		{
			pair = map.get(i);
			if (pair != null)
			{
				source = pair[0];
				target = pair[1];

				StringBuilder temp = new StringBuilder();
				int j = i;
				for (int c = 0; j < S.length() && c < source.length(); j++, c++)
				{
					temp.append(S.charAt(j));
				}

				String sub = temp.toString();
				if (sub.equals(source))
				{
					sb.append(target);
				}
				else
				{
					sb.append(sub);
				}
				i = j - 1;
			}
			else
			{
				sb.append(S.charAt(i));
			}
		}

		return sb.toString();
	}

	public static void main(String[] args)
	{
		System.out.println(new FindAndReplaceInString().findReplaceString("vmokgggqzp", new int[]{3, 5, 1}, new String[]{"kg", "ggq", "mo"}, new String[]{"s", "so", "bfr"}));
		System.out.println(new FindAndReplaceInString().findReplaceString("abcd", new int[]{0, 2}, new String[]{"ab", "ec"}, new String[]{"eee", "ffff"}));
		System.out.println(new FindAndReplaceInString().findReplaceString("abcd", new int[]{0, 2}, new String[]{"a", "cd"}, new String[]{"eee", "ffff"}));
	}
}
