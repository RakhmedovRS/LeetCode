package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 1/7/2021
 */
@LeetCode(
		id = 937,
		name = "Reorder Data in Log Files",
		url = "https://leetcode.com/problems/reorder-data-in-log-files/",
		difficulty = Difficulty.EASY
)
public class ReorderDataInLogFiles
{
	public String[] reorderLogFiles(String[] logs)
	{
		char separator = ' ';
		List<String> letterLogs = new ArrayList<>();
		List<String> digitLogs = new ArrayList<>();

		int index;
		for (String log : logs)
		{
			index = log.indexOf(separator);
			if (Character.isDigit(log.charAt(index + 1)))
			{
				digitLogs.add(log);
			}
			else
			{
				letterLogs.add(log);
			}
		}

		letterLogs.sort((a, b) ->
		{
			int i1 = a.indexOf(separator);
			int i2 = b.indexOf(separator);
			String sub1 = a.substring(i1 + 1);
			String sub2 = b.substring(i2 + 1);
			if (sub1.equals(sub2))
			{
				return a.compareTo(b);
			}
			return sub1.compareTo(sub2);
		});

		int pos = 0;
		String[] answer = new String[logs.length];
		for (String letterLog : letterLogs)
		{
			answer[pos++] = letterLog;
		}

		for (String digitLog : digitLogs)
		{
			answer[pos++] = digitLog;
		}

		return answer;
	}

	public static void main(String[] args)
	{
		ReorderDataInLogFiles clazz = new ReorderDataInLogFiles();
		System.out.println(Arrays.toString(clazz.reorderLogFiles(new String[]
				{"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"})));
	}
}
