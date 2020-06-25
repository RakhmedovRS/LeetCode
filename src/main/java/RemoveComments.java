import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 25-Jun-20
 */
@LeetCode(id = 722, name = "Remove Comments", url = "https://leetcode.com/problems/remove-comments/")
public class RemoveComments
{
	public List<String> removeComments(String[] source)
	{
		List<String> answer = new ArrayList<>();
		boolean inComment = false;
		StringBuilder lineBuilder = new StringBuilder();
		for (String line : source)
		{
			char[] lineChars = line.toCharArray();

			if (!inComment)
			{
				lineBuilder = new StringBuilder();
			}

			int pos = 0;
			while (pos < line.length())
			{
				if (!inComment && lineChars[pos] == '/' && pos + 1 < line.length() && lineChars[pos + 1] == '*')
				{
					inComment = true;
					pos++;
				}
				else if (inComment && lineChars[pos] == '*' && pos + 1 < line.length() && lineChars[pos + 1] == '/')
				{
					inComment = false;
					pos++;
				}
				else if (!inComment && lineChars[pos] == '/' && pos + 1 < line.length() && lineChars[pos + 1] == '/')
				{
					break;
				}
				else if (!inComment)
				{
					lineBuilder.append(lineChars[pos]);
				}

				pos++;
			}

			if (!inComment && lineBuilder.length() > 0)
			{
				answer.add(lineBuilder.toString());
			}
		}

		return answer;
	}
}
