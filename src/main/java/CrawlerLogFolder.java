import common.LeetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 9/27/2020
 */
@LeetCode(id = 1598, name = "Crawler Log Folder", url = "https://leetcode.com/problems/crawler-log-folder/")
public class CrawlerLogFolder
{
	public int minOperations(String[] logs)
	{
		Deque<String> stack = new LinkedList<>();
		for (String log : logs)
		{
			if ("../".equals(log))
			{
				if (stack.size() > 0)
				{
					stack.pop();
				}
			}
			else if (!"./".equals(log))
			{
				stack.push(log);
			}
		}

		return stack.size();
	}
}
