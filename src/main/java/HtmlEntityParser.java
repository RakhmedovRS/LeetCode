import common.Difficulty;
import common.LeetCode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 3/11/2021
 */
@LeetCode(
	id = 1410,
	name = "HTML Entity Parser",
	url = "https://leetcode.com/problems/html-entity-parser/",
	difficulty = Difficulty.MEDIUM
)
public class HtmlEntityParser
{
	public String entityParser(String text)
	{
		Map<String, String> map = new HashMap<>();
		map.put("&quot;", "\"");
		map.put("&apos;", "'");
		map.put("&amp;", "&");
		map.put("&gt;", ">");
		map.put("&lt;", "<");
		map.put("&frasl;", "/");

		StringBuilder sb = new StringBuilder();
		int prevPos = 0;
		Deque<Integer> deque = new LinkedList<>();
		for (int i = 0; i < text.length(); i++)
		{
			if (text.charAt(i) == '&')
			{
				if (!deque.isEmpty())
				{
					int curr = deque.pop();
					for (int j = prevPos; j <= curr; j++)
					{
						sb.append(text.charAt(j));
					}
					prevPos = curr + 1;
				}
				else
				{
					for (int j = prevPos; j < i; j++)
					{
						sb.append(text.charAt(j));
					}
				}

				deque.push(i);
			}
			else if (text.charAt(i) == ';')
			{
				if (!deque.isEmpty())
				{
					int start = deque.pop();
					String key = text.substring(start, i + 1);
					if (map.containsKey(key))
					{
						sb.append(map.get(key));
					}
					else
					{
						while (start <= i)
						{
							sb.append(text.charAt(start++));
						}
					}
				}
				else
				{
					for (int j = prevPos; j <= i; j++)
					{
						sb.append(text.charAt(j));
					}
				}
				prevPos = i + 1;
			}
		}

		while (prevPos < text.length())
		{
			sb.append(text.charAt(prevPos++));
		}

		return sb.toString();
	}
}
