package tasks;

import common.LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 9/27/2020
 */
@LeetCode(id = 399, name = "Evaluate Division", url = "https://leetcode.com/problems/evaluate-division/")
public class EvaluateDivision
{
	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries)
	{
		double[] result = new double[queries.size()];
		Arrays.fill(result, -1);
		Map<String, String> parent = new HashMap<>();
		Map<String, Double> rank = new HashMap<>();
		for (int i = 0; i < equations.size(); i++)
		{
			String a = equations.get(i).get(0);
			String b = equations.get(i).get(1);
			String aParent = findParent(parent, rank, a);
			String bParent = findParent(parent, rank, b);
			parent.put(aParent, bParent);
			rank.put(aParent, rank.get(b) * values[i] / rank.get(a));
		}

		for (int i = 0; i < queries.size(); i++)
		{
			String a = queries.get(i).get(0);
			String b = queries.get(i).get(1);
			if (rank.containsKey(a) && rank.containsKey(b))
			{
				String aParent = findParent(parent, rank, a);
				String bParent = findParent(parent, rank, b);
				if (aParent.equals(bParent))
				{
					result[i] = rank.get(a) / rank.get(b);
				}
			}
		}

		return result;
	}

	private String findParent(Map<String, String> parent, Map<String, Double> rank, String string)
	{
		if (!parent.containsKey(string))
		{
			parent.put(string, string);
			rank.put(string, 1D);
			return string;
		}

		if (string.equals(parent.get(string)))
		{
			return string;
		}

		String par = parent.get(string);
		String root = findParent(parent, rank, par);
		parent.put(string, root);
		rank.put(string, rank.get(string) * rank.get(par));
		return root;
	}
}
