package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 02-Aug-20
 */
@LeetCode(
		id = 609,
		name = "Find Duplicate File in System",
		url = "https://leetcode.com/problems/find-duplicate-file-in-system/",
		difficulty = Difficulty.MEDIUM
)
public class FindDuplicateFileInSystem
{
	public List<List<String>> findDuplicate(String[] paths)
	{
		String[] parts;
		Map<String, List<String>> map = new HashMap<>();
		for (String path : paths)
		{
			parts = path.split(" ");
			for (int i = 1; i < parts.length; i++)
			{
				String fileName = parts[i].substring(0, parts[i].indexOf('('));
				String fileContent = parts[i].substring(parts[i].indexOf('(') + 1, parts[i].indexOf(')'));

				map.putIfAbsent(fileContent, new ArrayList<>());
				map.get(fileContent).add(parts[0] + "/" + fileName);
			}
		}

		List<List<String>> answer = new ArrayList<>();
		for (List<String> list : map.values())
		{
			if (list.size() > 1)
			{
				answer.add(list);
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
