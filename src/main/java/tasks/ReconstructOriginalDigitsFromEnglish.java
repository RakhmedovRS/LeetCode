package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 13-Jul-20
 */
@LeetCode(
		id = 423,
		name = "Reconstruct Original Digits from English",
		url = "https://leetcode.com/problems/reconstruct-original-digits-from-english/",
		difficulty = Difficulty.MEDIUM
)
public class ReconstructOriginalDigitsFromEnglish
{
	public String originalDigits(String s)
	{
		int[] numbers = new int[10];
		int[][] tables = new int[10][];
		tables[0] = buildTable("zero");
		tables[1] = buildTable("one");
		tables[2] = buildTable("two");
		tables[3] = buildTable("three");
		tables[4] = buildTable("four");
		tables[5] = buildTable("five");
		tables[6] = buildTable("six");
		tables[7] = buildTable("seven");
		tables[8] = buildTable("eight");
		tables[9] = buildTable("nine");

		int[] table = buildTable(s);
		dfs(table, tables, numbers);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < numbers.length; i++)
		{
			while (numbers[i]-- > 0)
			{
				sb.append(i);
			}
		}
		return sb.toString();
	}

	private boolean dfs(int[] table, int[][] tables, int[] numbers)
	{
		boolean contains = false;
		for (int i = 0; i < 26; i++)
		{
			if (table[i] != 0)
			{
				contains = true;
				break;
			}
		}

		int ways;
		for (int i = 0; i < tables.length; i++)
		{
			ways = waysToCreateNumber(table, tables[i]);
			if (ways > 0)
			{
				process(table, tables[i], -ways);
				numbers[i] += ways;
				if (dfs(table, tables, numbers))
				{
					return true;
				}
				process(table, tables[i], ways);
				numbers[i] -= ways;
			}
		}


		return !contains;
	}

	private int[] buildTable(String word)
	{
		int[] table = new int[26];
		for (char ch : word.toCharArray())
		{
			table[ch - 'a']++;
		}

		return table;
	}

	private int waysToCreateNumber(int[] tableA, int[] tableB)
	{
		int ways = Integer.MAX_VALUE;
		for (int i = 0; i < tableA.length; i++)
		{
			if (tableB[i] == 0)
			{
				continue;
			}
			ways = Math.min(ways, tableA[i] / tableB[i]);
		}

		return ways;
	}

	private void process(int[] tableA, int[] tableB, int add)
	{
		for (int i = 0; i < tableA.length; i++)
		{
			tableA[i] += add * tableB[i];
		}
	}
}
