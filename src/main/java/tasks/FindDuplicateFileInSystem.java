package tasks;

import common.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 02-Aug-20
 */
@LeetCode(id = 609, name = "Find Duplicate File in System", url = "https://leetcode.com/problems/find-duplicate-file-in-system/")
public class FindDuplicateFileInSystem
{
	public List<List<String>> findDuplicate(String[] paths)
	{
		Map<String, List<String>> map = new HashMap<>();
		for (String path : paths)
		{
			String[] parts = path.split(" ");
			for (int i = 1; i < parts.length; i++)
			{
				int j = parts[i].length() - 2;
				StringBuilder sb = new StringBuilder();
				for (; parts[i].charAt(j) != '('; j--)
				{
					sb.append(parts[i].charAt(j));
				}
				String content = sb.reverse().toString();
				map.putIfAbsent(content, new ArrayList<>());
				map.get(content).add(parts[0] + "/" + parts[i].substring(0, j));
			}
		}

		List<List<String>> answer = new ArrayList<>();
		for (Map.Entry<String, List<String>> entry : map.entrySet())
		{
			if (entry.getValue().size() > 1)
			{
				answer.add(entry.getValue());
			}
		}

		return answer;
	}

	public static void main(String[] args)
	{
		System.out.println(new FindDuplicateFileInSystem().findDuplicate(
			new String[]{
				"root/a 1.txt(abcd) 2.txt(efgh)",
				"root/c 3.txt(abcd)",
				"root/c/d 4.txt(efgh)",
				"root 4.txt(efgh)"}));
	}
}
